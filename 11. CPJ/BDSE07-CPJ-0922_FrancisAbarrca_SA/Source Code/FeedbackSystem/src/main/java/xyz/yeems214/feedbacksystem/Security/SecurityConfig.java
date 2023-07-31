package xyz.yeems214.feedbacksystem.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .failureUrl("/login_error")
                .permitAll()
                .defaultSuccessUrl("/login_success", true)
                .and()
                .csrf().ignoringAntMatchers("/api/**", "addToCart", "/login_success", "/login_error", "/logout", "/login", "/register", "/about", "/contact", "/dashboard", "/home", "/member", "/donator")
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/assets/**").permitAll()
                .antMatchers("/style/**").permitAll()
                .antMatchers(HttpMethod.GET, "/dashboard").permitAll()
                .antMatchers(HttpMethod.GET, "/register").permitAll()
                .antMatchers(HttpMethod.GET, "/about").permitAll()
                .antMatchers(HttpMethod.GET, "/contact").permitAll()
                .antMatchers(HttpMethod.GET, "/login").permitAll()
                .antMatchers(HttpMethod.GET, "/home").permitAll()
                .antMatchers(HttpMethod.GET, "/member").hasAnyRole("Member")
                .antMatchers(HttpMethod.GET, "/donator").hasAnyRole("Donator")
                .antMatchers("/WEB-INF/**").permitAll() // Allow access to resources in the WEB-INF folder
                .and()
                .logout()
                .logoutSuccessUrl("/logout")
                .invalidateHttpSession(true);

        http.exceptionHandling().accessDeniedPage("/accessdenied");
    }
}
