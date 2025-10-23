package org.nigel.models;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    public String getName() {
        return name;
    }

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    // Constructor

    public Dealership(String name, String address, String phone, ArrayList<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehicleList = new ArrayList<>();
        for (int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getPrice() < max && inventory.get(i).getPrice() > min) {
                vehicleList.add(inventory.get(i));
            }
        }
        return vehicleList;
    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> vehicleList = new ArrayList<>();
        for (int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getMake().equalsIgnoreCase(make) && inventory.get(i).getModel().equalsIgnoreCase(model)) {
                vehicleList.add(inventory.get(i));
            }
        }
        return vehicleList;
    }
    public List<Vehicle> getVehiclesByYear(int year) {
        List<Vehicle> vehicleList = new ArrayList<>();
        for (int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getYear() == year) {
                vehicleList.add(inventory.get(i));
            }
        }
        return vehicleList;
    }
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> vehicleList = new ArrayList<>();
        for (int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getColor().equalsIgnoreCase(color)) {
                vehicleList.add(inventory.get(i));
            }
        }
        return vehicleList;
    }
    public List<Vehicle> getVehiclesByMileage(double min, double max) {
        List<Vehicle> vehicleList = new ArrayList<>();
        for (int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getOdometer() < max && inventory.get(i).getOdometer() > min) {
                vehicleList.add(inventory.get(i));
            }
        }
        return vehicleList;
    }
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> vehicleList = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                vehicleList.add(vehicle);

            }

        }
        return vehicleList;
    }
    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    //
    @Override
    public String toString() {
        StringBuilder formatCsvStyle = new StringBuilder();
        formatCsvStyle.append(name).append("|").append(address).append("|").append(phone).append("\n");
        for (Vehicle vehicle : inventory) {
            formatCsvStyle.append(vehicle.getVin()).append("|").append(vehicle.getYear()).append("|").append(vehicle.getMake()).append("|").append(vehicle.getModel()).append("|").append(vehicle.getVehicleType()).append("|").append(vehicle.getColor()).append("|").append(vehicle.getOdometer()).append("|").append(vehicle.getPrice()).append("\n");
        }
        return formatCsvStyle.toString();
    }
}

