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


}