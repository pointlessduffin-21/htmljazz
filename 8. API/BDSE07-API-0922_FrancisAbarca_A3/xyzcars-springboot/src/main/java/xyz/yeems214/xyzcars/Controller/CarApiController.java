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
    @GetMapping(value = "/t3st")
    public String t3st() {
        return "t3st";
    }

    // Add Car
    @PostMapping(value = "/addCar")
    public String register(@RequestBody Car c) {
        System.out.println(c); // Prints the car information inputted by the user
        carRestApiService.addCar(c);
        return "Car added";
    }

    // Delete Car
    @DeleteMapping(value = "/deleteCar/{id}")
    public String delete(@PathVariable Integer id) {
        carRestApiService.deleteCar(id);
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
