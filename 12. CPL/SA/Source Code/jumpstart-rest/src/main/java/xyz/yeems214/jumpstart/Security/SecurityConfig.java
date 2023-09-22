//package xyz.yeems214.jumpstart.Security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
////import xyz.yeems214.jumpstart.Security.CustomUserDetailsService;
////import xyz.yeems214.jumpstart.Security.JwtAuthenticationEntryPoint;
////import xyz.yeems214.jumpstart.Security.JwtAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Bean(BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable().exceptionHandling().and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .authorizeRequests(authorize -> authorize
//                                .antMatchers("/", "/favicon.ico", "/**/*.png", "/**/*.gif", "/**/*.svg", "/**/*.jpg",
//                                        "/**/*.html", "/**/*.css", "/**/*.js", "/showMemberOrder/**")
//                                .permitAll()
//                                .antMatchers("/api/**").permitAll()
//                                .antMatchers("/api/auth/**").permitAll()
//                                .antMatchers("/api/roles").permitAll()
//                                .antMatchers("/addDonor").permitAll()
//
//                                .antMatchers("/donors").permitAll()
//                                .antMatchers("/totalDonors").permitAll()
////                        .antMatchers("/api/meal/search").permitAll()
//                                .antMatchers("/api/meal/showMenu").permitAll()
//                                .antMatchers("/api/meal/mealdetails/**").permitAll()
//                                .antMatchers("/api/meal/images/1/735caa6a-4a75-4297-98e7-6e633aabb63b_strawberytoast.jpg").permitAll()
//                                .antMatchers("/api/users/{userId}/address").hasRole("MEMBER")
//                                .antMatchers(HttpMethod.GET, "/api/meal/images/**").permitAll()
//                                .antMatchers(HttpMethod.GET, "**/api/meal/images/**").permitAll()
////                        .antMatchers(HttpMethod.GET, "/api/images/**").permitAll()
////                        .antMatchers(HttpMethod.GET, "/api/order/**").permitAll()
////                        .antMatchers(HttpMethod.POST, "/api/order/**").permitAll()
////                        .antMatchers(HttpMethod.POST, "/member/api/users/{userId}/address/").permitAll()
////                        .antMatchers(HttpMethod.GET, "/api/meal/**").hasRole("MEMBER")
////                        .antMatchers(HttpMethod.POST, "/api/meal/**").hasRole("MEMBER")
////                        .antMatchers("/api/meal/showMenu").hasRole("ADMINISTRATOR")
//
//                                .anyRequest().authenticated()
//                );
//    }
//}
