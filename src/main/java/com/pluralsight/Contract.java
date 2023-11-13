package com.pluralsight;

public abstract class Contract {

    protected String date,customerName,email;
    protected Vehicle carSold;
    protected double totalPrice,monthlyPayment;
    //constructor

    public Contract(String date, String customerName, String email, Vehicle carSold) {
        this.date = date;
        this.customerName = customerName;
        this.email = email;
        this.carSold = carSold;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Vehicle getCarSold() {
        return carSold;
    }

    public void setCarSold(Vehicle carSold) {
        this.carSold = carSold;
    }

    abstract double getTotalPrice();
    abstract double getMonthlyPayment();

}
