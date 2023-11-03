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

    public void getAllVehicles() {
        Vehicle cars;
        for (Vehicle car : inventory) {
            System.out.println(car);
        }

    }

    public void removeVehicle(int index){
        inventory.remove(index);
    }

    public ArrayList getVehiclesByPrice(double min,double max){
        return null;
    }
    public ArrayList getVehiclesByMakeModel(String make, String model){
        return null;
    }
    public ArrayList getVehiclesByYear(int min, int max){
        return null;
    }
    public ArrayList getVehiclesByColor(String color){
        return null;
    }
    public ArrayList getVehiclesByMilage(int min, int max){
        return null;
    }
    public ArrayList getVehiclesByType(String vehicleType){
        return null;
    }

}
