package com.yeems214.student.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {
    @GetMapping("/rest")
    public String testRestMethod() {
        return "Rest Testing Success!";
    }
}