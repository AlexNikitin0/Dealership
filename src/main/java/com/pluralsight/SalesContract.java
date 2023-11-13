package com.pluralsight;

public class SalesContract extends Contract{

    private double salesTax = .05;
    private double recordingFee = 100;
    private double processingFee; //295 for vehicles under 10k and 495 for over
    private boolean finance;
    private double monthlyPayment;
    //all loans are 4.5% for 48 mo if price is 10k or more
    //otherwise loans are 5.25% for 24 months.


    public SalesContract(String date, String customerName, String email, Vehicle carSold, boolean finance) {
        super(date, customerName, email, carSold);
        this.finance = finance;

    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }
    @Override
    public double getTotalPrice(){


        double recordingFee = 100;
        if(carSold.getPrice() < 10000){
            processingFee = 295;
        }
        else {
            processingFee = 495;
        }
       totalPrice = carSold.getPrice() + processingFee + (salesTax * carSold.getPrice()) + recordingFee;
        return totalPrice;
    }
    @Override
    public double getMonthlyPayment(){
        double rate = 0;
        double term = 0;
        double power = Math.pow(1 + rate,term);
        if(isFinance()){
            if(carSold.getPrice() > 10000){
                 rate = .0425;
                 term = 48;
                power = Math.pow(1 + (rate/12),term);
                 monthlyPayment = getTotalPrice() * ((rate/12) * power) / (power - 1);
            }
            else{
                rate = .0525;
                term = 24;
                power = Math.pow(1 + rate,term);
                monthlyPayment = getTotalPrice() * ((rate/12) * power) / (power - 1);
            }
        }
        else return 0;

        return monthlyPayment;


        //Monthly payment = (loan amount) × (interest rate / 12) / (1 − (1 + (interest rate / 12)) ^ (-loan term)).
    }

    public double getTaxes(){

        return carSold.getPrice() * salesTax;
    }

}
