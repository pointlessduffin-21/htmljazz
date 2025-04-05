package com.Group1.MealsOnWheels.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Fund {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long f_id;
    private String name;
    private String amount;
    private LocalDateTime dateTime;
    private Long donor_id;
    private String Paypal;

    public Fund() {

    }



    public Fund(Long f_id, String name, String amount, LocalDateTime dateTime, Long donor_id, String paypal) {
        super();
        this.f_id = f_id;
        this.name = name;
        this.amount = amount;
        this.dateTime = dateTime;
        this.donor_id = donor_id;
        Paypal = paypal;
    }



    public Long getF_id() {
        return f_id;
    }

    public void setF_id(Long f_id) {
        this.f_id = f_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }



    public Long getDonor_id() {
        return donor_id;
    }



    public void setDonor_id(Long donor_id) {
        this.donor_id = donor_id;
    }



    public String getPaypal() {
        return Paypal;
    }



    public void setPaypal(String paypal) {
        Paypal = paypal;
    }



    public Fund(String name, String amount, LocalDateTime dateTime) {
        this.name = name;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public Fund(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }

    public Fund(String name) {
        this.name = name;
    }

    public Fund(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateTime.format(formatter);
        return "Funds [f_id=" + f_id + ", name=" + name + ", amount=" + amount + ", dateTime=" + dateTime
                + ", donor_id=" + donor_id + ", Paypal=" + Paypal + ", formatter=" + formatter + ", formattedDate="
                + formattedDate + "]";
    }




}

