package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ContractFileManager {



    public void saveContract(ArrayList<Contract> contracts )throws IOException {
        FileWriter fileWriter = new FileWriter("src/main/resources/Contracts.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Contract con : contracts) {
            if (con instanceof SalesContract) {
                bufferedWriter.write( "SALE " + con.getDate() + "|" + con.getCustomerName() + "|" + con.getEmail() + "|" + "$" + con.getTotalPrice() + "|" + con.getCarSold().getYear() + "|" + "\n");
                bufferedWriter.write("\t" + con.getCarSold().getMake() + "|" + con.getCarSold().getModel() + "|" + con.getCarSold().getVehicleType() + "|" + con.getCarSold().getColor() + "|" + con.getCarSold().getOdometer() + "|" + con.getCarSold().getPrice() + "|" + "\n");
                bufferedWriter.write("\t" + ((SalesContract) con).getTaxes() + "|" + ((SalesContract) con).getRecordingFee() + "|" + ((SalesContract) con).getProcessingFee() + "|" + con.getTotalPrice() + "|" + ((SalesContract) con).isFinance() + "|" + con.getMonthlyPayment() + "|" + "\n");


            } else if (con instanceof LeaseContract) {
                bufferedWriter.write( "LEASE " + con.getDate() + "|" + con.getCustomerName() + "|" + con.getEmail() + "|" + "$" + con.getTotalPrice() + "|" + con.getCarSold().getYear() + "|" + "\n");
                bufferedWriter.write("\t" + con.getCarSold().getMake() + "|" + con.getCarSold().getModel() + "|" + con.getCarSold().getVehicleType() + "|" + con.getCarSold().getColor() + "|" + con.getCarSold().getOdometer() + "|" + con.getCarSold().getPrice() + "|" + "\n");
                bufferedWriter.write("\t" + ((LeaseContract) con).getEndingValue() + "|" + ((LeaseContract) con).getLeaseFee() + "|" + con.getTotalPrice() + "|" + con.getMonthlyPayment() + "|" + "\n");

            }
        }
        bufferedWriter.close();
    }
}
