package xyz.yeems214.xyzcars.Controller;

import xyz.yeems214.xyzcars.Entity.Users;
import xyz.yeems214.xyzcars.Service.userRestApiServiceImpl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class UserApiController {
    @Autowired
    userRestApiServiceImpl userRestApiService;

    @GetMapping(value = "/userGrab")
    public Principal getUser(final Principal user) {
        return user;
    }

    // Add User
    @PostMapping(value="/addUser")
    public String register(@RequestBody Users u) {
        System.out.println(u); // Prints the user information inputted by the user
        userRestApiService.addUser(u);
        return "User added";
    }

    // Delete User
    @DeleteMapping(value="/deleteUser/{id}")
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
    @GetMapping(value="/login")
    public String login(@RequestParam String userName, @RequestParam String password) {
        if (userRestApiService.userExists(userName, password)) {
            return "Login success!";
        } else {
            return "Login failed!";
        }
    }
}
