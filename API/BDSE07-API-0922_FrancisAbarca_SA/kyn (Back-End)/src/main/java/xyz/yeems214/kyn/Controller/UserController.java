package xyz.yeems214.kyn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xyz.yeems214.kyn.Entity.Users;
import xyz.yeems214.kyn.Service.UserServiceImpl;

import java.security.Principal;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping(value = "/userGrab")
    public Principal getUser(final Principal user) {
        return user;
    }

    // Add User
    @PostMapping(value="/register")
    public String register(@RequestBody Users u) {
        System.out.println(u); // Prints the user information inputted by the user
        userService.addUser(u);
        return "User added";
    }

    // Delete User
    @DeleteMapping(value="/deleteUser/{id}")
    public String delete(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "User deleted";
    }

    // Show All Uesrs
    @GetMapping(value="/allUsers")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    // Search User by Keyword
    @GetMapping(value="/searchUser")
    public List<Users> searchUser(@RequestParam String key) {
        return userService.searchByName(key);
    }

    // Login
    @GetMapping(value="/login")
    public String login(@RequestParam String userName, @RequestParam String password) {
        if (userService.userExists(userName, password)) {
            return "Login success!";
        } else {
            return "Login failed!";
        }
    }
}