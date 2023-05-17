package com.yeems214.xyzcars.Controller;

import com.yeems214.xyzcars.Entity.Users;
import com.yeems214.xyzcars.Service.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.yeems214.xyzcars.Service.UserService;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {
    UserImpl userService;
    @GetMapping("/register")
    public String register(@ModelAttribute("user") Users u) {
        userService.AddUser(u);
        return "index";
    }


}