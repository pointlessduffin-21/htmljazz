package com.merrymeals.mealsonwheels.Entity;

import java.util.Objects;

public class PaymentRequest{
    private int id;
    private String amount;
    private String currency;

    public PaymentRequest() {
    }

    public PaymentRequest(int id, String amount, String currency) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public String getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "id=" + id +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentRequest)) return false;
        PaymentRequest that = (PaymentRequest) o;
        return getId() == that.getId() && getAmount().equals(that.getAmount()) && getCurrency().equals(that.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAmount(), getCurrency());
    }
}