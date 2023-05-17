package com.yeems214.xyzcars.Service;

import com.yeems214.xyzcars.Entity.Cars;
import java.util.List;

public interface CarService {
    void AddCar(Cars car);
    void DeleteCar(Cars car);
    public List<Cars> ShowCars();
    public List<Cars> SearchByName(String cname);
}