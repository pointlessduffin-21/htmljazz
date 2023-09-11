package com.yeems214.student.Controller;

import com.yeems214.student.Service.StudentImplementation;
import com.yeems214.student.Entity.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StudentController {
    @Autowired
    StudentImplementation studentService;

    @GetMapping(value = "/")
    public String home() {
        return "index";
    }

    @GetMapping(value = "/about")
    public String about() {
        return "about";
    }

    @GetMapping(value = "/admission")
    public String admission() {
        return "admission";
    }

    @GetMapping(value = "/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping(value = "/whyus")
    public String whyus() {
        return "whyus";
    }

    @PostMapping(value = "/sendCustomer")
    public String sendCustomer() {
        return "/";
    }
}