package com.Group1.MealsOnWheels.security;

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
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/distancematrixniroel", "/addfundsniroel", "/tablefundsniroel").permitAll()
                .antMatchers("/css/**", "/images/**", "/js/**").permitAll()
                .antMatchers(HttpMethod.GET, "/favicon.*", "/login", "/login_success").permitAll()
                .antMatchers(HttpMethod.POST, "/home").permitAll()
                .antMatchers(HttpMethod.GET, "/prfiole", "/car_detail").hasAnyRole("Users", "Administrator")
                .antMatchers(HttpMethod.GET, "/member").hasRole("Member")
                .antMatchers(HttpMethod.GET, "/donator").hasRole("Donator")
                .antMatchers(HttpMethod.GET, "/kitchen", "/addmeal", "/createMeal").hasRole("Partner")
                .antMatchers(HttpMethod.GET, "/volunteer").hasRole("Volunteer")
                .antMatchers(HttpMethod.GET, "/admin").hasRole("Administrator")
                .antMatchers(HttpMethod.GET, "/funds/all").permitAll() // Allow access to "/funds/all" for all roles
                .antMatchers(HttpMethod.POST, "/funds/create").hasAnyRole("Users", "Administrator") // Allow access to "/funds/create" for "Users" and "Administrator" roles
                .antMatchers(HttpMethod.PUT, "/funds/update/{id}").hasAnyRole("Users", "Administrator") // Allow access to "/funds/update/{id}" for "Users" and "Administrator" roles
                .antMatchers(HttpMethod.DELETE, "/funds/delete/{id}").hasAnyRole("Users", "Administrator") // Allow access to "/funds/delete/{id}" for "Users" and "Administrator" roles
                .antMatchers(HttpMethod.POST, "/api/createfunds").permitAll() // Allow access to "/distance/{origin}/{destination}" for all roles
                .antMatchers(HttpMethod.GET, "/api/greeting").permitAll()
                .antMatchers(HttpMethod.GET, "/api/allfunds", "/orders/pendingOrders", "/orders/readyOrders", "/orders/deliveredOrders").permitAll()
                .antMatchers(HttpMethod.POST, "/api/{origin}/{destination}").permitAll()// Allow access to "/api/greeting" for all roles
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true);
    }

}
