package xyz.yeems214.xyzcars.Controller;

import xyz.yeems214.xyzcars.Entity.Car;
import xyz.yeems214.xyzcars.Service.carRestApiServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarApiController {
    @Autowired
    carRestApiServiceImpl carRestApiService;

    // Test
    @GetMapping(value = "/test")
    public String test() {
        return "test";
    }

    // Add Car
    @PostMapping(value = "/addCar")
    public String register(@RequestBody Car c) {
        System.out.println(c); // Prints the car information inputted by the user
        carRestApiService.addCar(c);
        return "Car added";
    }

    // Delete Car
    @DeleteMapping(value = "/deleteCar")
    public String delete(@RequestBody Car c) {
        carRestApiService.deleteCar(c);
        return "Car deleted";
    }

    // Show All Cars
    @GetMapping(value = "/showCars")
    public List<Car> showAllCars() {
        return carRestApiService.getAllCars();
    }

    // View Car Details
    @GetMapping(value = "/viewCar")
    public Optional<Car> viewCarDetails(@RequestParam Integer id) {
        return carRestApiService.getCarById(id);
    }

    // Search Car by Keyword
    @GetMapping(value = "/searchCar")
    public List<Car> searchCar(@RequestParam String keyword) {
        return carRestApiService.search(keyword);
    }

    // Search Car by Price
    @GetMapping(value = "/searchCarByPrice")
    public List<Car> searchCarByPrice(@RequestParam String min, @RequestParam String max) {
        List<Car> carPriceResult = carRestApiService.searchByPrice(min, max);
        return carPriceResult;
    }
}
