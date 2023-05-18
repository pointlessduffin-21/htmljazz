package xyz.yeems214.xyzcars.Controller;

import xyz.yeems214.xyzcars.Entity.Car;
import xyz.yeems214.xyzcars.Service.carRestApiServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarApiController {
    @Autowired
    carRestApiServiceImpl carRestApiService;

    @GetMapping(value = "/test")
    public String test() {
        return "test";
    }

    @PostMapping(value = "/addCar")
    public String register(@RequestBody Car c) {
        System.out.println(c); // Prints the car information inputted by the user
        carRestApiService.addCar(c);
        return "Car added";
    }

    @GetMapping(value = "/searchCars")
    public String searchCars() {
        return "Car searched";
    }

}

