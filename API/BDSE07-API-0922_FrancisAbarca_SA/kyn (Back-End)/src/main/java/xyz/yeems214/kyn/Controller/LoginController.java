package xyz.yeems214.kyn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.yeems214.kyn.Entity.User;
import xyz.yeems214.kyn.Service.UserServiceImpl;

@RestController
public class LoginController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping(value="/test")
    public String test() {
        return "Test";
    }

    @PostMapping(value="/login")
    public String login(@RequestBody User u) {
        if (userService.userExists(u.getUserName(), u.getPassword())) {
            return "Login success!";
        } else {
            return "Login failed!";
        }
    }
}