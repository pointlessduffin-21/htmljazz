package xyz.yeems214.kyn.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String role;

    public Users() {
    }

    public Users(String userName, String password, String email, String firstName, String lastName, String address, String phoneNumber, String role) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
    	this.password = password;
    }

    public void setEmail(String email) {
    	this.email = email;
    }

    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }

    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }

    public void setAddress(String address) {
    	this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
    	this.phoneNumber = phoneNumber;
    }

    public void setRole(String role) {
    	this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password=" + password +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", phoneNumber=" + phoneNumber +
                ", role=" + role +
                '}';
    }


}