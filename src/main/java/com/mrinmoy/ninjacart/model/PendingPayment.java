package com.mrinmoy.ninjacart.model;

import java.time.LocalDate;
public class PendingPayment implements Comparable<PendingPayment>{
    private String id;
    private String type;
    private LocalDate dueDate;
    private double amount;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(PendingPayment pendingPayment) {
        return dueDate.compareTo(pendingPayment.getDueDate());
    }
}
