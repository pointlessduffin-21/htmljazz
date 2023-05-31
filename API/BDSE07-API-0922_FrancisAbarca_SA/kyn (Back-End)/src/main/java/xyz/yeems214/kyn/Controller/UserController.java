package xyz.yeems214.kyn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.yeems214.kyn.Entity.Users;
import xyz.yeems214.kyn.Service.userRestApiServiceImpl;

import java.security.Principal;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    userRestApiServiceImpl userRestApiService;

    // Add User
    @PostMapping(value="/addUser")
    public String register(@RequestBody Users u) {
        System.out.println(u); // Prints the user information inputted by the user
        userRestApiService.addUser(u);
        return "User added";
    }

    /// Delete User
    @DeleteMapping(value="/user/deleteUser/{id}")
    public String delete(@PathVariable Integer id) {
        userRestApiService.deleteUser(id);
        return "User deleted";
    }

    // Show All Uesrs
    @GetMapping(value="/allUsers")
    public List<Users> getAllUsers() {
        return userRestApiService.getAllUsers();
    }

    // Search User by Keyword
    @GetMapping(value="/searchUser")
    public List<Users> searchUser(@RequestParam String key) {
        return userRestApiService.searchByName(key);
    }

    // Login
    @GetMapping(value="/oldLogin")
    public String login(@RequestParam String userName, @RequestParam String password) {
        if (userRestApiService.userExists(userName, password)) {
            return "Login success!";
        } else {
            return "Login failed!";
        }
    }

    // New Login
    @PostMapping(value="/internalLogin")
    public String login(@RequestBody Users u) {
        if (userRestApiService.userExists(u.getUserName(), u.getPassword())) {
            return "Login success!";
        } else {
            return "Login failed!";
        }
    }

}