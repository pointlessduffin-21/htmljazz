package com.yeems214.xyzcars.Service;

import com.yeems214.xyzcars.Entity.Users;

import java.util.List;

public interface UserService {
    void AddUser(Users user);
    void deleteUser(Users user);

    public List<Users> showAll();

    public List<Users> searchByName(String firstName);
    Users findByUsername(String username);
    Boolean validateUser(String username, String password);
}

