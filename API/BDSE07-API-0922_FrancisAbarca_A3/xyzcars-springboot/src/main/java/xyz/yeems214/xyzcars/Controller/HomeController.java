package xyz.yeems214.xyzcars.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class HomeController {
    @GetMapping
    public Principal getUser(final Principal user) {
        return user;
    }
}