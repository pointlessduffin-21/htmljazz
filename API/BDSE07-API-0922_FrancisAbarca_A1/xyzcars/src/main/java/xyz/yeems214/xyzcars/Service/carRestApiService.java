package xyz.yeems214.xyzcars.Service;

import xyz.yeems214.xyzcars.Entity.Car;

import java.util.List;
import java.util.Optional;

public interface carRestApiService {

    void addCar(Car c);

    void deleteCar(Integer id);

    List<Car> getAllCars();
    Optional<Car> getCarById(Integer id);
    List<Car> search(String key);
    List<Car> searchByPrice(String min, String max);

}