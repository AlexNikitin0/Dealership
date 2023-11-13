package com.pluralsight;

public class LeaseContract extends Contract{
    double endingValue,leaseFee,monthlyPayment;

    public LeaseContract(String date, String customerName, String email, Vehicle carSold) {
        super(date, customerName, email, carSold);
            this.endingValue = carSold.getPrice() / 2;
            this.leaseFee = carSold.getPrice() * .07;
    }

    public double getEndingValue() {
        return endingValue;
    }

    public void setEndingValue(double endingValue) {
        this.endingValue = endingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }
    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }


    @Override
    public double getMonthlyPayment() {
        double rate = 0;
        double term = 0;
        double power = 0;
        rate = .04;
        term = 36;
        power = Math.pow(1 + (rate/12),term);
        monthlyPayment = getTotalPrice() * ((rate/12) * power) / (power - 1);


        return monthlyPayment;
    }


    @Override
    public double getTotalPrice(){

        double endingValue = carSold.getPrice() / 2;
        double leaseFee = .07;
        totalPrice = endingValue + (carSold.getPrice() * leaseFee);
        return totalPrice;
    }

}
