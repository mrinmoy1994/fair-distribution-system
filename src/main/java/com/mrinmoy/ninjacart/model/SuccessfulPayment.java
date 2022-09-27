package com.mrinmoy.ninjacart.model;

import java.time.LocalDate;
public class SuccessfulPayment {
    private String id;
    private String type;
    private LocalDate dueDate;
    private double amount;
    private LocalDate paymentDate;
    private String paymentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "SuccessfulPayment{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", dueDate=" + dueDate +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", paymentId='" + paymentId + '\'' +
                '}';
    }
}
