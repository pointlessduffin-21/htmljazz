package com.yeems214.assignment5.service;

import java.util.HashSet;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yeems214.assignment5.entity.User;
import com.yeems214.assignment5.repository.RoleRepository;
import com.yeems214.assignment5.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String saveUser(User user) {

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        user.setRoles(new HashSet<>(roleRepository.findBySpecificRoles("Users")));

        userRepository.save(user);

        return "User saved successfully";
    }

    @Override
    public User findLoginUser(String username) {

        return userRepository.findByUserName(username);
    }
}
