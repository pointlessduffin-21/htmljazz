package com.yeems214.assignment5.security;

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
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("At Authen configure");
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        System.out.println("At Security configure");
        http

                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .failureUrl("/login_error")
                .permitAll()
                .defaultSuccessUrl("/login_success", true)
                .and()
                .csrf()
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers(HttpMethod.GET, "/favicon.*").permitAll()
                .antMatchers(HttpMethod.GET, "/login").permitAll()
                .antMatchers(HttpMethod.GET, "/home").hasAnyRole("Users","Administrator")
                .antMatchers(HttpMethod.GET, "/view_store").hasAnyRole("Users","Administrator")
                .antMatchers(HttpMethod.GET, "/search_store").hasAnyRole("Users","Administrator")
                .antMatchers(HttpMethod.POST, "/saveStore").hasRole("Administrator")
                .antMatchers(HttpMethod.GET, "/addStore").hasRole("Administrator")
                .antMatchers(HttpMethod.GET, "/update").hasRole("Administrator")
                .antMatchers(HttpMethod.GET, "/delete").hasRole("Administrator")
                .and()
                .logout()
                .logoutSuccessUrl("/logout")
                .invalidateHttpSession(true);

        http.exceptionHandling().accessDeniedPage("/accessdenied");

    }
}





