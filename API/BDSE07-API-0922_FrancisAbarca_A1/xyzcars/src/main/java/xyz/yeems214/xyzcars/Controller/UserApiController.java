package xyz.yeems214.xyzcars.Controller;

import xyz.yeems214.xyzcars.Entity.Users;
import xyz.yeems214.xyzcars.Service.userRestApiServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {
    @Autowired
    userRestApiServiceImpl userRestApiService;

    @PostMapping(value="/addUser")
    public String register(@RequestBody Users u) {
        System.out.println(u); // Prints the user information inputted by the user
        userRestApiService.addUser(u);
        return "User added";
    }

}