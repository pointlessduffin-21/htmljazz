package xyz.yeems214.jumpstart.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public Long id;
    public String location;
    public String address;

    public Long phoneNumber;

    public Branch() {
    }

    public Branch(String location, String address, Long phoneNumber) {
        this.location = location;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getAddress() {
        return address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public Branch setId(Long id) {
        this.id = id;
        return this;
    }

    public Branch setLocation(String location) {
        this.location = location;
        return this;
    }

    public Branch setAddress(String address) {
        this.address = address;
        return this;
    }

    public Branch setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
