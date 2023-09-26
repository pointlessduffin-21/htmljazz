package com.Group1.MealsOnWheels.security;


import com.Group1.MealsOnWheels.Entity.Role;
import com.Group1.MealsOnWheels.Entity.User;
import com.Group1.MealsOnWheels.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

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
     * Default Authentication mechanism calls this method to get UserDetails by the name given at the time of login.
     * This method returns UserDetails with password and roles he/she plays.
     * Spring then verifies the password given by the user with this password and authenticates the user.
     */
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(userName);
        if(user == null) {
            throw new UsernameNotFoundException("user " + userName + " is not valid. Please re-enter.");
        }
        org.springframework.security.core.userdetails.User.UserBuilder userBuilder = org.springframework.security.core.userdetails.User.builder();

        Long UId = user.getId();
        String roleName= userRepository.findRoleByUid(UId);

        System.out.println("Role Name is "+roleName);

        return userBuilder.username(user.getUserName())
                .password(user.getPassword())
                .roles(roleName)
                //.passwordEncoder(passwordEncoder::encode)
                .build();
    }
}
