package com.pluralsight;

import com.pluralsight.Dealership;
import com.pluralsight.DealershipFileManager;

import java.io.IOException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;


public class UserInterface {

    public static ArrayList<Contract> contracts = new ArrayList<>();
    Scanner keyboard = new Scanner(System.in);
    
    private void init() throws IOException {

            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.getDealership();
            ContractFileManager contractFileManager = new ContractFileManager();
            contractFileManager.saveContract(contracts);



    }
    
    
    //display method
    public void display() throws IOException {
        init();
        int choice;


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
        System.out.println("10)Buy a car: ");
        System.out.println("11)Lease a car: ");
        System.out.println("12)QUIT");
        choice = keyboard.nextInt();
        keyboard.nextLine();
        
        //decision structure

        switch(choice) {
            case 1: 
                processGetByPriceRequest();
                display();
                break;
            case 2:
                processGetByMakeModelRequest();
                display();
                break;
            case 3:
                processGetByYearRequest();
                display();
                break;
            case 4:
                processGetByColorRequest();
                display();
                break;
            case 5:
                processGetByMilageRequest();
                display();
                break;
            case 6:
                processGetByVehicleType();
                display();
                break;
            case 7:
                processGetAllVehiclesRequest();
                display();
                break;
            case 8:
                processAddVehicleRequest();
                display();
                break;
            case 9:
                processRemoveVehicleRequest();
                display();
                break;
            case 10:
                processBuyVehicleRequest();//make method
                break;
            case 11:
                processLeaseVehicleRequest();//make method
                break;
            case 12:
                System.exit(0);
            default:
                System.out.printf("Invalid input");
                break;
        }
        }
        


    private void processRemoveVehicleRequest() {
    }

    private void processAddVehicleRequest() throws IOException{
        System.out.print("Enter VIN: ");
        int vin = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Enter the year: ");
        int year = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Enter the Make: ");
        String make = keyboard.nextLine();
        System.out.print("Enter the Model: ");
        String model = keyboard.nextLine();
        System.out.print("Enter the Vehicle Type: ");
        String type = keyboard.nextLine();
        System.out.print("Enter the color: ");
        String color = keyboard.nextLine();
        System.out.println("Enter the milage: ");
        int milage =  keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Enter the price ");
        double price = keyboard.nextDouble();
        keyboard.nextLine();
        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(vin,year,make,model,type,color,milage,price);
        System.out.println("Vehicle added!");
        display();
    }

    private void processGetAllVehiclesRequest() throws IOException{
        displayVehicles();
    }

    private void processGetByVehicleType() {
        System.out.println("Enter the vehicle type: ");
        String type = keyboard.nextLine();
       ArrayList<Vehicle> vehiclesByType = DealershipFileManager.dealership.getVehiclesByType(type);
       for(Vehicle car: vehiclesByType){
           System.out.printf(" vin: %d  Year: %d  Make: %s  Model: %s  Type: %s  Color: %s  Milage: %d  Price: %.2f \n",car.getVin(),car.getYear(),car.getMake(),car.getModel(),car.getVehicleType(),car.getColor(),car.getOdometer(),car.getPrice());

       }
    }

    private void processGetByMilageRequest() {
        System.out.println("Enter the minimum milage: ");
        int minMiles = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Enter the maximum milage: ");
        int maxMiles = keyboard.nextInt();
        keyboard.nextLine();
        ArrayList<Vehicle> vehiclesByType = DealershipFileManager.dealership.getVehiclesByMilage(minMiles,maxMiles);
        for(Vehicle car: vehiclesByType){
            System.out.printf(" vin: %d  Year: %d  Make: %s  Model: %s  Type: %s  Color: %s  Milage: %d  Price: %.2f \n",car.getVin(),car.getYear(),car.getMake(),car.getModel(),car.getVehicleType(),car.getColor(),car.getOdometer(),car.getPrice());

        }
    }

    private void processGetByColorRequest() {
        System.out.print("Enter the vehicle color: ");
        String type = keyboard.nextLine();
        ArrayList<Vehicle> vehiclesByType = DealershipFileManager.dealership.getVehiclesByColor(type);
        for(Vehicle car: vehiclesByType){
            System.out.printf(" vin: %d  Year: %d  Make: %s  Model: %s  Type: %s  Color: %s  Milage: %d  Price: %.2f \n",car.getVin(),car.getYear(),car.getMake(),car.getModel(),car.getVehicleType(),car.getColor(),car.getOdometer(),car.getPrice());

        }
    }

    private void processGetByYearRequest() {
        System.out.print("Enter the minimum vehicle Year: ");
        int min = keyboard.nextInt();
        System.out.print("Enter the maximum vehicle Year: ");
        int max = keyboard.nextInt();
        ArrayList<Vehicle> vehiclesByType = DealershipFileManager.dealership.getVehiclesByYear(min,max);
        for(Vehicle car: vehiclesByType){
            System.out.printf(" vin: %d  Year: %d  Make: %s  Model: %s  Type: %s  Color: %s  Milage: %d  Price: %.2f \n",car.getVin(),car.getYear(),car.getMake(),car.getModel(),car.getVehicleType(),car.getColor(),car.getOdometer(),car.getPrice());

        }
    }

    private void processGetByMakeModelRequest() {
        System.out.print("Enter the make: ");
        String make = keyboard.nextLine();
        System.out.print("Enter the model: ");
        String model = keyboard.nextLine();
        ArrayList<Vehicle> vehiclesByType = DealershipFileManager.dealership.getVehiclesByMakeModel(make,model);
        for(Vehicle car: vehiclesByType){
            System.out.printf(" vin: %d  Year: %d  Make: %s  Model: %s  Type: %s  Color: %s  Milage: %d  Price: %.2f \n",car.getVin(),car.getYear(),car.getMake(),car.getModel(),car.getVehicleType(),car.getColor(),car.getOdometer(),car.getPrice());

        }
    }

    private void processGetByPriceRequest() {
        System.out.print("Enter the minimum price: ");
        double min = keyboard.nextDouble();
        System.out.print("Enter the maximum price: ");
        double max = keyboard.nextDouble();
        ArrayList<Vehicle> vehiclesByType = DealershipFileManager.dealership.getVehiclesByPrice(min,max);
        for(Vehicle car: vehiclesByType){
            System.out.printf(" vin: %d  Year: %d  Make: %s  Model: %s  Type: %s  Color: %s  Milage: %d  Price: %.2f \n",car.getVin(),car.getYear(),car.getMake(),car.getModel(),car.getVehicleType(),car.getColor(),car.getOdometer(),car.getPrice());

        }
    }

    private void displayVehicles()throws IOException{
       ArrayList<Vehicle> test = DealershipFileManager.dealership.getAllVehicles();

        for(Vehicle car :test){
            System.out.println();
            System.out.printf(" vin: %d  Year: %d  Make: %s  Model: %s  Type: %s  Color: %s  Milage: %d  Price: %.2f ",car.getVin(),car.getYear(),car.getMake(),car.getModel(),car.getVehicleType(),car.getColor(),car.getOdometer(),car.getPrice());
            System.out.println();
        }
        display();

    }

    private void showList()throws IOException{
        ArrayList<Vehicle> test = DealershipFileManager.dealership.getAllVehicles();

        for(Vehicle car :test){
            System.out.println();
            System.out.printf(" vin: %d  Year: %d  Make: %s  Model: %s  Type: %s  Color: %s  Milage: %d  Price: %.2f ",car.getVin(),car.getYear(),car.getMake(),car.getModel(),car.getVehicleType(),car.getColor(),car.getOdometer(),car.getPrice());
            System.out.println();
        }


    }

    private void processBuyVehicleRequest ()throws IOException{
        int choice;
        boolean isFinance;
        System.out.println("Are you financing? ");
        System.out.println("Yes(1)");
        System.out.println("No(2)");
        choice = keyboard.nextInt();
        keyboard.nextLine();
        if(choice == 1){
            isFinance = true;
        }
        else {
            isFinance = false;
        }
        LocalDate date =  LocalDate.now();
        System.out.println("What is your first and last name: ");
        String name = keyboard.nextLine();
        System.out.println("What is your email: ");

        String email = keyboard.nextLine();
        System.out.println("Please enter the VIN number of the vehicle of interest: ");
        showList();
        int VIN = keyboard.nextInt();
        keyboard.nextLine();
        //init new salesContract
        SalesContract salesContract = new SalesContract(date.toString(),name,email,DealershipFileManager.dealership.getVehicleByVin(VIN).get(0),isFinance);
        contracts.add(salesContract);
        init();
    }

    private void  processLeaseVehicleRequest()throws IOException{
        LocalDate date =  LocalDate.now();
        System.out.println("What is your first and last name: ");
        String name = keyboard.nextLine();
        System.out.println("What is your email: ");
        String email = keyboard.nextLine();
        System.out.println("Please enter the VIN number of the vehicle of interest: ");
        showList();
        int VIN = keyboard.nextInt();
        //init new LeaseContract
        LeaseContract leaseContract = new LeaseContract(date.toString(),name,email,DealershipFileManager.dealership.getVehicleByVin(VIN).get(0));
        contracts.add(leaseContract);


        init();
    }


}
