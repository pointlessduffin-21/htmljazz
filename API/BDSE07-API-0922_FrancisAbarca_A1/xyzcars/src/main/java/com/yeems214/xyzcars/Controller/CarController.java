package com.yeems214.xyzcars.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {
    @Autowired
    CarImpl carService;

    @GetMapping("/")
    public String home() {
        return "index";
    }


}
