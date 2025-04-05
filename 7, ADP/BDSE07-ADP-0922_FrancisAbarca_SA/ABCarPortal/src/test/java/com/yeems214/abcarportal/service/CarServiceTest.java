package com.yeems214.abcarportal.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.yeems214.abcarportal.model.Car;
import com.yeems214.abcarportal.model.CarBidding;
import com.yeems214.abcarportal.model.User;
import com.yeems214.abcarportal.repository.BidRepository;
import com.yeems214.abcarportal.repository.CarRepository;



@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @InjectMocks
    CarService carService;

    @Mock
    CarRepository carRepository;

    @Mock
    BidRepository bidRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveCar() {
        Car car = new Car();
        car.setId((long) 1);
        car.setName("2021 Tesla Model 3");
        car.setModel("Tesla Model 3");
        car.setPrice("1795000");
        car.setMake("2021");
        car.setRegisteration("March 21, 2022");
        Mockito.when(carRepository.save(car)).thenReturn(car);
        Car savedCar = carService.save(car);
        Assert.assertEquals(car, savedCar);
    }

    @Test
    public void testSearchCar() {
        Car car = new Car();
        String searchInput = "Tesla";
        car.setModel(searchInput);

        List<Car> searchCar = new ArrayList<Car>();
        searchCar.add(car);

        Mockito.when(carRepository.search(searchInput)).thenReturn(searchCar);
        List<Car> search = carService.search(searchInput);
        Assert.assertEquals(searchCar, search);
    }


    @Test
    public void testSaveCarBidding() {
        Car car = new Car();
        car.setName("2021 Tesla Model 3");
        User user = new User();
        user.setName("Kevin");
        CarBidding bid = new CarBidding();
        bid.setCar(car);
        bid.setUser(user);
        bid.setBidderPrice(1550000);

        Mockito.when(bidRepository.save(bid)).thenReturn(bid);
        CarBidding saveBid = carService.saveBid(bid);
        Assert.assertEquals(bid, saveBid);
    }
}
