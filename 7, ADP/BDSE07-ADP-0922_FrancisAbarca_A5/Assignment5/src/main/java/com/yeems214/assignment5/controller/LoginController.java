package com.yeems214.assignment5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yeems214.assignment5.entity.User;
import com.yeems214.assignment5.service.UserService;


@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @GetMapping("login")
    public String onLogin() {
        return "login";
    }
    @GetMapping("login_error")
    public String onLoginError(Model model) {
        String error_msg = "Incorrect username or password. Try Again.";
        model.addAttribute("error_string", error_msg);
        return "login";
    }

    @GetMapping("login_success")
    public String onLoginSuccess(Model model) {

        String success_login = "Successfully logged In!";
        model.addAttribute("success_login", success_login);

        return "login";
    }

    @GetMapping("logout")
    public String onLogoutSuccess(Model model) {

        String success_logout = "Successfully logged Out!";
        model.addAttribute("success_logout", success_logout);

        return "login";
    }

    @GetMapping("register_user")
    public String showRegistrationForm(@ModelAttribute("user") User user) {


        return "Register";
    }

    @PostMapping("register")
    public String registerNewUser(@ModelAttribute("user") User user, Model model) {

        String response = userService.saveUser(user);
        System.out.println(response);

        String success_register = "Registeration Successful! ";
        model.addAttribute("success_register", success_register);

        return "login";
    }



}
