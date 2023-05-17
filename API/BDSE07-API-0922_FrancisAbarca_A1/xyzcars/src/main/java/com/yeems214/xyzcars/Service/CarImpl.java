package com.yeems214.xyzcars.Service;

import com.yeems214.xyzcars.Entity.Cars;
import com.yeems214.xyzcars.Repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CarService")
public class CarImpl implements CarService {
    @Autowired
    CarsRepository carRepo;

    @Override
    public void AddCar(Cars car) {
        carRepo.save(car);
        System.out.println("Successfully added car.");

        // TODO Auto-generated method stub
    }

    public void DeleteCar(Cars car) {
        carRepo.delete(car);
        System.out.println("Successfully deleted car.");
    }

    @Override
    public List<Cars> ShowCars() {
        // TODO Auto-generated method stub

        return carRepo.findAll();
    }

    @Override
    public List<Cars> SearchByName(String cname) {

        return carRepo.searchByName(cname);
    }
}