package xyz.yeems214.xyzcars.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Principal getUser(final Principal user) {
        return user;
    }

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
