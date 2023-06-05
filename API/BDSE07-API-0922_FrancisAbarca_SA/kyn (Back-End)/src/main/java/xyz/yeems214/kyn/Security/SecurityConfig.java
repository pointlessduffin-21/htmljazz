package xyz.yeems214.kyn.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import xyz.yeems214.kyn.Service.userRestApiServiceImpl;
import xyz.yeems214.kyn.Repository.UsersRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private userRestApiServiceImpl userService;

    @Autowired
    private UsersRepository userRepository;

    public SecurityConfig(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedDoubleSlash(true);
        return firewall;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/test","/addUser", "/internalLogin", "/oldLogin" ,"/login","/webjars/**", "/error**", "/searchUser", "/allUsers", "/index")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .and()
                .oauth2Login();

        return http.build();
    }
}
