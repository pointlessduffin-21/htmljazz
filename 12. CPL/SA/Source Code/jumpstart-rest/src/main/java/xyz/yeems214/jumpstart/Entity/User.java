package xyz.yeems214.jumpstart.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String username;
    private String address;
    private Long phoneNumber;
    private String email;
    private String password;
    private LocalDateTime registrationDateTime;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role_id;

    public User() {
    }

public User(String name, String username, String address, Long phoneNumber, String email, String password, LocalDateTime registrationDateTime, Role role_id) {
        this.name = name;
        this.username = username;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.registrationDateTime = registrationDateTime;
        this.role_id = role_id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }
    
    public String getAddress() {
        return address;
    }
    
    public Long getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getRegistrationDateTime() {
        return registrationDateTime;
    }

    public Role getRole_id() {
        return role_id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public User setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
    
    public User setRegistrationDateTime(LocalDateTime registrationDateTime) {
        this.registrationDateTime = registrationDateTime;
        return this;
    }
    
    public User setRole_id(Role role_id) {
        this.role_id = role_id;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", registrationDateTime=" + registrationDateTime +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role_id=" + role_id +
                '}';
    }
}
