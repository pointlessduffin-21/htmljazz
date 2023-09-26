package com.yeems214.assignment5.service;


import com.yeems214.assignment5.entity.User;


public interface UserService {
    // User saveUser(User user);
    String saveUser(User user);

    User findLoginUser(String username);

}
