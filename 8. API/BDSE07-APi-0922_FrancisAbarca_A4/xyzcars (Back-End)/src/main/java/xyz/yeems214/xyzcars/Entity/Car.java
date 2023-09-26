package xyz.yeems214.xyzcars.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer carId;
    private String make;
    private String model;
    private String registration;
    private String price;

    public Car() {
    }

    public Car(Integer carId, String make, String model, String registration, String price) {
        super();
        this.carId = carId;
        this.make = make;
        this.model = model;
        this.registration = registration;
        this.price = price;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", registration='" + registration + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

}