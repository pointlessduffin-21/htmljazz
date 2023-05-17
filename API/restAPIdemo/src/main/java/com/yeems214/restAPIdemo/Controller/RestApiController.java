package com.yeems214.restAPIdemo.Controller;

import com.yeems214.restAPIdemo.Entity.User;
import com.yeems214.restAPIdemo.Service.RestApiService;
import com.yeems214.restAPIdemo.Service.RestApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {
    @Autowired
    RestApiServiceImpl restApiService;

    @GetMapping(value = "/test")
    public String test() {
        return "test success";
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody User u) {
        restApiService.addData(u);
        return "register success";
    }

}