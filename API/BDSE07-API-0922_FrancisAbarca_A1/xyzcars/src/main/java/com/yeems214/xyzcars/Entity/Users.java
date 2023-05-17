package com.yeems214.xyzcars.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    public Users() {

    }

    public Integer getUserId() {
    	return userId;
    }

    public void setUserId(Integer userId) {
    	this.userId = userId;
    }

    public String getFirstName() {
    	return firstName;
    }

    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }

    public String getLastName() {
    	return lastName;
    }

    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }

    public String getUserEmail() {
    	return userEmail;
    }

    public void setUserEmail(String userEmail) {
    	this.userEmail = userEmail;
    }

    public String getUserName() {
    	return userName;
    }

    public void setUserName(String userName) {
    	this.userName = userName;
    }

    public String getUserPassword() {
    	return userPassword;
    }

    public void setUserPassword(String userPassword) {
    	this.userPassword = userPassword;
    }

    public Users (Integer userId, String userName, String userEmail, String userPassword, String firstName, String lastName) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}