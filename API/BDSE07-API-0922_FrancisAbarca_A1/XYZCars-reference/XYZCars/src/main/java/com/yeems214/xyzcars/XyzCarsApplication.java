package com.yeems214.xyzcars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class XyzCarsApplication {
    @RequestMapping
    String home(@RequestParam(required = false) String name) {
        if(name != null) {
            return "Hello " + name + "!";
        } else {
            return "Hello World!";
        }
    }
    public static void main(String[] args) {
        SpringApplication.run(XyzCarsApplication.class, args);
    }

}
