package com.yeems214.xyzcars.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="cars")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    private Integer carId;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "car_make")
    private String carMake;

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "car_registerDate")
    private String registrationDate;

    @Column(name = "car_price")
    private String carPrice;

    public Cars() {

    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId() {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName() {
        this.carName = carName;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake() {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel() {
        this.carModel = carModel;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice() {
        this.carPrice = carPrice;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate() {
        this.registrationDate = registrationDate;
    }

    public Cars (Integer carId, String carName, String carMake, String carModel, String registrationDate, String carPrice) {
        this.carId = carId;
        this.carName = carName;
        this.carMake = carMake;
        this.carModel = carModel;
        this.registrationDate = registrationDate;
        this.carPrice = carPrice;
    }

    @Override
    public String toString() {
        return "Cars [carId=" + carId + ", carName=" + carName + ", carMake=" + carMake + ", carModel=" + carModel + ", registrationDate=" + registrationDate + ", carPrice=" + carPrice + "]";
    }
}