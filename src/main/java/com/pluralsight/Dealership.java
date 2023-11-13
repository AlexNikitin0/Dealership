package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    //prop
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>();
    }
    //getters
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getPhone(){
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //methods
    public void addVehicle(Vehicle car){
        inventory.add(car);
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return this.inventory;

    }

    public void removeVehicle(int vin){


        for(Vehicle car : inventory){
            if(car.getVin() == vin){
                inventory.remove(inventory.indexOf(car));
            }
        }
    }

    public ArrayList<Vehicle> getVehicleByVin(int vin){
        ArrayList<Vehicle> cars;
        cars = new ArrayList<>();
        for(Vehicle car : inventory){
            if(car.getVin() == vin){
                 cars.add(car);
            }
        }
        return cars;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max){
        ArrayList<Vehicle> cars;
        cars = new ArrayList<>();
        for(Vehicle car : inventory){
            if(car.getPrice() >= min && car.getPrice() <= max){
                cars.add(car);
            }
        }
       return cars;
    }
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> cars;
        cars = new ArrayList<>();
        for(Vehicle car : inventory){
            if(car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model)){
                cars.add(car);
            }
        }
        return cars;
    }
    public ArrayList<Vehicle> getVehiclesByYear(int min, int max){

        ArrayList<Vehicle> cars;
        cars = new ArrayList<>();
        for(Vehicle car : inventory){
            if(car.getYear() >= min && car.getYear() <= max){
                cars.add(car);
            }
        }
        return cars;
    }
    public ArrayList<Vehicle> getVehiclesByColor(String color){

        ArrayList<Vehicle> cars;
        cars = new ArrayList<>();
        for(Vehicle car : inventory){
            if(car.getColor().equalsIgnoreCase(color)){
                cars.add(car);
            }
        }
        return cars;
    }
    public ArrayList<Vehicle> getVehiclesByMilage(int min, int max){
        ArrayList<Vehicle> cars;
        cars = new ArrayList<>();
        for(Vehicle car : inventory){
            if(car.getOdometer() >= min && car.getOdometer() <= max){
                cars.add(car);
            }
        }
        return cars;

    }
    public ArrayList<Vehicle> getVehiclesByType(String vehicleType){
        ArrayList<Vehicle> cars;
        cars = new ArrayList<>();
        for(Vehicle car : inventory){
            if(car.getVehicleType().equalsIgnoreCase(vehicleType)){
                cars.add(car);
            }
        }
        return cars;

    }

}
