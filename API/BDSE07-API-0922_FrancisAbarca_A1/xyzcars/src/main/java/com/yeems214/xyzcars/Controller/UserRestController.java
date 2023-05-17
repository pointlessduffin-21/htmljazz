package com.yeems214.xyzcars.Controller;

import com.yeems214.xyzcars.Entity.Users;
import com.yeems214.xyzcars.Service.CarService;
import com.yeems214.xyzcars.Service.UserService;
import com.yeems214.xyzcars.Service.CarImpl;
import com.yeems214.xyzcars.Component.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    @Autowired
    UserService userService;
    JwtProvider jwtProvider;

    @GetMapping("/testrest")
    public String testRest() {
        return "Test Success!";
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody Users user) {
        System.out.println(user.getUserName());
        userService.AddUser(user);
        return "Data successfully added!";
    }

    @PostMapping("/testLogin")
    public ResponseEntity<?> login(@RequestBody Users loginUser) {
        Users user = userService.findByUsername(loginUser.getUserName());
        if (user != null && userService.validateUser(loginUser.getUserName(), loginUser.getUserPassword())) {
            String jwt = jwtProvider.generateToken(loginUser.getUserName());
            return ResponseEntity.ok("Login Successful!");
        } else {
            return ResponseEntity.badRequest().body("Login Failed!");
        }
    }



}