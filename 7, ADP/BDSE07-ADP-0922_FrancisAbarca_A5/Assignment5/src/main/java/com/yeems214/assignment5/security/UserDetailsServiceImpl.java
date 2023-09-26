package com.yeems214.assignment5.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.yeems214.assignment5.entity.Role;
import com.yeems214.assignment5.entity.User;
import com.yeems214.assignment5.repository.UserRepository;

import javax.transaction.Transactional;

@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl() {
    }

    /*
     * This method is called by Spring Security to get the user details from the database.
     * Spring Security uses the user name to load the user details from the database.
     * If the user is not found, it will throw UsernameNotFoundException.
     */
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(userName);
        if(user == null) {
            throw new UsernameNotFoundException("user " + userName + " is not valid. Please re-enter.");
        }
        org.springframework.security.core.userdetails.User.UserBuilder userBuilder = org.springframework.security.core.userdetails.User.builder();

        String[] roleNames= user.getRoles().stream().map(Role::getName).toArray(String[]::new);

        System.out.println("Role Name is "+roleNames);

        return userBuilder.username(user.getUserName())
                .password(user.getPassword())
                .roles(roleNames)
                //.passwordEncoder(passwordEncoder::encode)
                .build();
    }
}
