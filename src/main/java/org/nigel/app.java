package org.nigel;

import org.nigel.models.Dealership;
import org.nigel.models.Vehicle;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static org.nigel.DealershipFileManager.loadDealership;

public class app {
    // application init
    public static ArrayList<Dealership> Dealerships = new ArrayList<>();
    private static boolean loadedInit = false;
    private static Dealership currentDealership = null;
    //
    private static void loadInit() {
        if(!loadedInit) {
            loadDealership();
            currentDealership = Dealerships.getFirst();

            loadedInit = true;
        }
    }
    static void startApplication() {
        loadInit(); // initalize init
        display(); // display menu
        Scanner scan = new Scanner(System.in); // scanner start
        userInterface(scan); // start the user interface
    }

    private static void userInterface(Scanner scan) {
        boolean keepScreenOpen = true;
        while (keepScreenOpen) {
            System.out.print("Dealership: ");
            String argument = scan.nextLine();
            switch (argument) {
                case "1":
                    try{
                        System.out.print("Min Price: ");
                        double minArgument = scan.nextDouble();
                        System.out.print("Max Price: ");

                        double maxArgument = scan.nextDouble();
                        scan.nextLine();

                        List< Vehicle > allVehicles = currentDealership.getVehiclesByPrice(minArgument, maxArgument);
                        System.out.println("==Price Filter==");
                        for (Vehicle allVehicle : allVehicles) {
                            System.out.printf("Year: %d | Vin: %s | Model: %s | Make: %s | Miles: %s | Price: $%.2f %n", allVehicle.getYear(), allVehicle.getVin(), allVehicle.getModel(), allVehicle.getMake(), allVehicle.getOdometer(), allVehicle.getPrice());
                        }
                    }catch (InputMismatchException e) {
                        System.out.println("Can't put a string for a double");
                    }
                    break;
                case "2":
                    try{
                        System.out.print("Car Make: ");
                        String carMake = scan.nextLine();
                        System.out.print("Car Model: ");
                        String carModel = scan.nextLine();

                        List< Vehicle > allVehicles = currentDealership.getVehiclesByMakeModel(carMake, carModel);
                        System.out.println("===Make & Model==");
                        for (Vehicle allVehicle : allVehicles) {
                            System.out.printf("Year: %d | Vin: %s | Model: %s | Make: %s | Miles: %s | Price: $%.2f %n", allVehicle.getYear(), allVehicle.getVin(), allVehicle.getModel(), allVehicle.getMake(), allVehicle.getOdometer(), allVehicle.getPrice());
                        }
                    }catch (InputMismatchException e) {
                        System.out.println("Can't put a string for a double");
                    }
                    break;
                case "3":
                    try{
                        System.out.print("Car Year: ");
                        int carYear = scan.nextInt();
                        scan.nextLine();

                        List< Vehicle > allVehicles = currentDealership.getVehiclesByYear(carYear);
                        System.out.println("===Year Filter==");
                        for (Vehicle allVehicle : allVehicles) {
                            System.out.printf("Year: %d | Vin: %s | Model: %s | Make: %s | Miles: %s | Price: $%.2f %n", allVehicle.getYear(), allVehicle.getVin(), allVehicle.getModel(), allVehicle.getMake(), allVehicle.getOdometer(), allVehicle.getPrice());
                        }
                    }catch (InputMismatchException e) {
                        System.out.println("Can't put a string for a double");
                    }
                    break;
                case "4":
                    try{
                        System.out.print("Car Color: ");
                        String carColor = scan.nextLine();

                        List< Vehicle > allVehicles = currentDealership.getVehiclesByColor(carColor);
                        System.out.println("===Color==");
                        for (Vehicle allVehicle : allVehicles) {
                            System.out.printf("Year: %d | Vin: %s | Model: %s | Make: %s | Miles: %s | Price: $%.2f %n", allVehicle.getYear(), allVehicle.getVin(), allVehicle.getModel(), allVehicle.getMake(), allVehicle.getOdometer(), allVehicle.getPrice());
                        }
                    }catch (InputMismatchException e) {
                        System.out.println("Can't put a string for a double");
                    }
                    break;
                case "5":
                    try{
                        System.out.print("car miles min: ");
                        double milesMinArgument = scan.nextDouble();
                        System.out.print("car miles max: ");

                        double milesMaxArgument = scan.nextDouble();
                        scan.nextLine();

                        List< Vehicle > allVehicles = currentDealership.getVehiclesByMileage(milesMinArgument, milesMaxArgument);
                        System.out.println("==Miles Filter==");
                        for (Vehicle allVehicle : allVehicles) {
                            System.out.printf("Year: %d | Vin: %s | Model: %s | Make: %s | Miles: %s | Price: $%.2f %n", allVehicle.getYear(), allVehicle.getVin(), allVehicle.getModel(), allVehicle.getMake(), allVehicle.getOdometer(), allVehicle.getPrice());
                        }
                    }catch (InputMismatchException e) {
                        System.out.println("Can't put a string for a double");
                    }
                    break;
                case "6":
                    try{
                        System.out.print("Car type: ");
                        String carType = scan.nextLine();

                        List< Vehicle > allVehicles = currentDealership.getVehiclesByType(carType);
                        System.out.println("===type==");
                        for (Vehicle allVehicle : allVehicles) {
                            System.out.printf("Year: %d | Vin: %s | Model: %s | Make: %s | Miles: %s | Price: $%.2f %n", allVehicle.getYear(), allVehicle.getVin(), allVehicle.getModel(), allVehicle.getMake(), allVehicle.getOdometer(), allVehicle.getPrice());
                        
                        }
                    }catch (InputMismatchException e) {
                        System.out.println("Can't put a string for a double");
                    }
                    break;
                case "7":
                    System.out.println("==All Vehicles==");
                    List< Vehicle > allVehicles = currentDealership.getAllVehicles();
                    for (Vehicle allVehicle : allVehicles) {
                        System.out.printf("Year: %d | Vin: %s | Model: %s | Make: %s | Miles: %s | Price: $%.2f %n", allVehicle.getYear(), allVehicle.getVin(), allVehicle.getModel(), allVehicle.getMake(), allVehicle.getOdometer(), allVehicle.getPrice());
                    }
                    break;
                case "8":
                    int carVin = (int) Math.round(Math.random() * 99999);
                    System.out.print("Car Year: ");
                    String carYear = scan.nextLine();

                    System.out.print("Car Brand: ");
                    String carBrand = scan.nextLine();

                    System.out.print("Car Model: ");
                    String carModel = scan.nextLine();

                    System.out.print("Car Type: ");
                    String carType = scan.nextLine();

                    System.out.print("Car Color: ");
                    String carColor = scan.nextLine();

                    System.out.print("Car Miles: ");
                    String carMiles = scan.nextLine();

                    System.out.print("Car Price: ");
                    String carPrice = scan.nextLine();

                    Vehicle vehicle = new Vehicle(carVin, Integer.parseInt(carYear), carBrand, carModel, carType, carColor, Integer.parseInt(carMiles), Double.parseDouble(carPrice));
                    currentDealership.addVehicle(vehicle);
                    System.out.println("Added new vehicle!");
                    break;
                case "9":
                    System.out.print("Delete by vin: ");
                    String carRemoveByVin = scan.nextLine();
                    Vehicle vehicleRemove = null;
                    List< Vehicle > totalVehicles = currentDealership.getAllVehicles();
                    for (Vehicle allVehicle : totalVehicles) {
                        if(allVehicle.getVin() == Integer.parseInt(carRemoveByVin)) {
                            vehicleRemove = new Vehicle(allVehicle.getVin(), allVehicle.getYear(), allVehicle.getMake(), allVehicle.getModel(), allVehicle.getVehicleType(), allVehicle.getColor(), allVehicle.getOdometer(), allVehicle.getPrice());
                        }
                    }
                    if(vehicleRemove != null) { // found car
                        currentDealership.removeVehicle(vehicleRemove);
                        System.out.println("Removed vehicle successfully!");

                    } else {
                        System.out.println("Couldn't remove vehicle.");
                    }
                    break;
                case "10":
                    System.out.println("Saved Dealership to csv file!");
                    DealershipFileManager.saveDealership(currentDealership);
                    break;
                case "99":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }
    private static void display() {
        System.out.println("\t=====Dealership " + currentDealership.getName() + "=====");
        System.out.println("\t1. Get by Price");
        System.out.println("\t2. Get by Make & Model");
        System.out.println("\t3. Get by Year");
        System.out.println("\t4. Get by Color");
        System.out.println("\t5. Get by Mileage");
        System.out.println("\t6. Get by Vehicle Type");
        System.out.println("\t7. Get all Vehicles");
        System.out.println("\t8. Add Vehicle");
        System.out.println("\t9. Remove Vehicle");
        System.out.println("\t10. Save Dealership");
    }
}
