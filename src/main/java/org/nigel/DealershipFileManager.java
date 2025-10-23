package org.nigel;

import org.nigel.models.Dealership;
import org.nigel.models.Vehicle;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {
    public static void loadDealership() {
        String FilePath = "files/inventory.csv";
        ArrayList< Vehicle> inventory = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FilePath));
            String firstLine = bufferedReader.readLine();
            String[] splitTextDealership = {};
            if(!firstLine.isEmpty()) { // if the first line isn't empty
                splitTextDealership = firstLine.split("\\|"); // split by |
            }

            String input;
            while((input = bufferedReader.readLine()) != null) {
                // 44901|2012|Honda|Civic|SUV|Gray|103221|6995.00
                String[] inputSplit = input.split("\\|");
                String carVin = inputSplit[0];
                String carYear = inputSplit[1];
                String carBrand = inputSplit[2];
                String carModel = inputSplit[3];
                String carType = inputSplit[4];
                String carColor = inputSplit[5];
                String carMiles = inputSplit[6];
                String carPrice = inputSplit[7];
                Vehicle vehicle = new Vehicle(Integer.parseInt(carVin), Integer.parseInt(carYear), carBrand, carModel, carType, carColor, Integer.parseInt(carMiles), Double.parseDouble(carPrice));
                inventory.add(vehicle);
            }
            Dealership dealership = new Dealership(splitTextDealership[0], splitTextDealership[1], splitTextDealership[2], inventory);
            app.Dealerships.add(dealership);
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void saveDealership(Dealership dealership) {
        try{
            String FilePath = "files/inventory.csv";
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FilePath));
            bufferedWriter.write(dealership.toString());
            bufferedWriter.close();
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
