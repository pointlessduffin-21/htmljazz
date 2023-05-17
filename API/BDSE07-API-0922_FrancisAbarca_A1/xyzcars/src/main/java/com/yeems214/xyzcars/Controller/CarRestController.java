package com.yeems214.xyzcars.Controller;

import com.yeems214.xyzcars.Entity.Cars;
import com.yeems214.xyzcars.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarRestController {
    @Autowired
    CarService carService;

    @PostMapping(value = "/addCar")
    public String addCar(@RequestBody Cars car) {
        carService.AddCar(car);
        return "Car successfully added!";
    }

    @PostMapping("/deleteCar")
    public String deleteCar(@RequestBody Cars car) {
        carService.DeleteCar(car);
        return "Car successfully deleted!";
    }

    @GetMapping("/showCars")
    public List<Cars> showCars() {
        return carService.ShowCars();
    }

    @GetMapping("/searchCar")
    public List<Cars> searchByName(@RequestParam String carName) {
        return carService.SearchByName(carName);
    }
}
