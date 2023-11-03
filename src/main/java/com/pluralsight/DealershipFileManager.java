package com.pluralsight;



import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {

    public static Dealership dealership;
        public static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void getDealership ()throws IOException{
        FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String input;


        while ((input = bufferedReader.readLine()) != null){
            String[] line = input.split("\\|");
            //read first line to get dealership info
            if(!line[0].contains("D & B")) {
                int vinNumber = Integer.parseInt(line[0]);
                int year = Integer.parseInt(line[1]);
                String make = line[2];
                String model = line[3];
                String vehicleType = line[4];
                String vehicleColor = line[5];
                int odometer = Integer.parseInt(line[6]);
                double price = Double.parseDouble(line[7]);
                Vehicle vehicle = new Vehicle(vinNumber,year,make,model,vehicleType,vehicleColor,odometer,price);
                 dealership.addVehicle(vehicle);
                }
            else {
                String dealershipName = line[0];
                String dealershipAddress = line[1];
                String dealershipPhone = line[2];
                dealership = new Dealership(dealershipName,dealershipAddress,dealershipPhone);
            }

        }
        bufferedReader.close();
    }

    public void saveDealership()throws IOException{
        FileWriter fileWriter = new FileWriter("src/main/resources/inventory.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

    }
}
