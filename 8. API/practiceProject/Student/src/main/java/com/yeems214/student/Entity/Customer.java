package com.yeems214.student.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CustomerId;
    private String CustomerName;
    private String CustomerEmail;
    private String CustomerPhone;
    private String CustomerMessage;

    public Customer() {

    }
    public Customer(Long customerId, String customerName, String customerEmail, String customerPhone,
            String customerMessage) {
        super();
        CustomerId = customerId;
        CustomerName = customerName;
        CustomerEmail = customerEmail;
        CustomerPhone = customerPhone;
        CustomerMessage = customerMessage;
    }
    @Override
    public String toString() {
        return "Customer [CustomerId=" + CustomerId + ", CustomerName=" + CustomerName + ", CustomerEmail="
                + CustomerEmail + ", CustomerPhone=" + CustomerPhone + ", CustomerMessage=" + CustomerMessage + "]";
    }
    public Long getCustomerId() {
        return CustomerId;
    }
    public void setCustomerId(Long customerId) {
        CustomerId = customerId;
    }
    public String getCustomerName() {
        return CustomerName;
    }
    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }
    public String getCustomerEmail() {
        return CustomerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }
    public String getCustomerPhone() {
        return CustomerPhone;
    }
    public void setCustomerPhone(String customerPhone) {
        CustomerPhone = customerPhone;
    }
    public String getCustomerMessage() {
        return CustomerMessage;
    }
    public void setCustomerMessage(String customerMessage) {
        CustomerMessage = customerMessage;
    }
}