package com.pluralsight;

import com.pluralsight.Dealership;
import com.pluralsight.DealershipFileManager;

import java.io.IOException;
import java.util.*;

public class UserInterface {
    
    private void init() throws IOException {

            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.getDealership();




    }
    
    
    //display method
    public void display() throws IOException {
        init();
        int choice;
        int keepGoing;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to CarMax!");
        System.out.println("1)Find Vehicles by Price: ");
        System.out.println("2)Find vehicles by make and model: ");
        System.out.println("3)Find vehicles by Year: ");
        System.out.println("4)Find vehicles by Color: ");
        System.out.println("5)Find vehicles by Milage: ");
        System.out.println("6)Find vehicles by Type: ");
        System.out.println("7)List all vehicles: ");
        System.out.println("8)Trade in a vehicle(Add): ");
        System.out.println("9)Send vehicle to auction(Remove): ");
        System.out.println("10)QUIT");
        choice = keyboard.nextInt();
        
        //decision structure
       while (true){
        switch(choice) {
            case 1: 
                processGetByPriceRequest();
                break;
            case 2:
                processGetByMakeModelRequest();
                break;
            case 3:
                processGetByYearRequest();
                break;
            case 4:
                processGetByColorRequest();
                break;
            case 5:
                processGetByMilageRequest();
                break;
            case 6:
                processGetByVehicleType();
                break;
            case 7:
                processGetAllVehiclesRequest();

                break;
            case 8:
                processAddVehicleRequest();
                break;
            case 9:
                processRemoveVehicleRequest();
                break;
            case 10:
                System.exit(0);
        }
        }
        
    }

    private void processRemoveVehicleRequest() {
    }

    private void processAddVehicleRequest() {
    }

    private void processGetAllVehiclesRequest() {
        displayVehicles();
    }

    private void processGetByVehicleType() {
    }

    private void processGetByMilageRequest() {
    }

    private void processGetByColorRequest() {
    }

    private void processGetByYearRequest() {
    }

    private void processGetByMakeModelRequest() {
    }

    private void processGetByPriceRequest() {
        
    }

    private void displayVehicles(){
        for(Vehicle car :DealershipFileManager.dealership.getAllVehicles()){
            System.out.printf(" vin: %d  Year: %d  Make: %s  Model: %s  Type: %s  Color: %s  Milage: %d  Price: %.2f ",car.getVin(),car.getYear(),car.getMake(),car.getModel(),car.getVehicleType(),car.getColor(),car.getOdometer(),car.getPrice());
        }

    }


}
