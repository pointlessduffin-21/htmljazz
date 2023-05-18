package xyz.yeems214.xyzcars.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yeems214.xyzcars.Entity.Car;
import xyz.yeems214.xyzcars.Entity.CarRepository;

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
}
