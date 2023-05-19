package xyz.yeems214.xyzcars.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yeems214.xyzcars.Entity.Car;
import xyz.yeems214.xyzcars.Entity.CarRepository;

import java.util.List;
import java.util.Optional;

@Service("carRestApiService")
public class carRestApiServiceImpl implements carRestApiService {
    @Autowired
    CarRepository carRepository;

    @Override
    public void addCar(Car c) {
        // TODO Auto-generated method stub
        carRepository.save(c);
        System.out.println("Car added successfully!");
    }

    @Override
    public void deleteCar(Car C) {
        // TODO Auto-generated method stub
        carRepository.delete(C);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCarById(Integer id) {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> search(String key) {
        return carRepository.search(key);
    }

    @Override
    public List<Car> searchByPrice(String min, String max) {
        return carRepository.searchByPrice(min, max);
    }


}
