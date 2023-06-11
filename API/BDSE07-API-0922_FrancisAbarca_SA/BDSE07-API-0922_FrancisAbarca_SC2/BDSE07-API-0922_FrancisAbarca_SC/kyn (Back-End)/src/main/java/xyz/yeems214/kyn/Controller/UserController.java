package xyz.yeems214.kyn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import xyz.yeems214.kyn.Entity.Users;
import xyz.yeems214.kyn.Service.userRestApiServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    userRestApiServiceImpl userRestApiService;

    // Test
    @GetMapping(value="/test")
    public String test() {
        return "Test successful!";
    }

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
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/oldLogin")
    public String login(@RequestParam String userName, @RequestParam String password) {
        if (userRestApiService.userExists(userName, password)) {
            return "Login success!";
        } else {
            return "Login failed!";
        }
    }

    // New Login
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value="/internalLogin")
    public String login(@RequestBody Users u) {
        if (userRestApiService.userExists(u.getUserName(), u.getPassword())) {
            return "Login success!";
        } else {
            return "Login failed!";
        }
    }

    // Logout
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value="/logout")
    public String logout(HttpServletRequest request) {
        // Invalidate the session, removing any session attributes
        request.getSession().invalidate();
        // Return a success message
        return "Logout successful!";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/checkAuthentication")
    public Map<String, Object> checkAuthentication() {
        Map<String, Object> map = new HashMap<>();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated()) {
            map.put("authenticated", true);
        } else {
            map.put("authenticated", false);
        }

        return map;
    }


}