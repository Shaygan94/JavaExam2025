import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    public List<Scrapyard> readScrapyard (String fileName) throws IOException {
        List<Scrapyard> scrapyardList = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(fileName))){
            int numberOfScrapyardID = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < numberOfScrapyardID; i++) {
                int scrapyardID = Integer.parseInt(scan.nextLine());
                String name = scan.nextLine();
                String address = scan.nextLine();
                String phoneNumber = scan.nextLine();
                scan.nextLine(); // ---
                scrapyardList.add(new Scrapyard(scrapyardID, name, address, phoneNumber));
            }
        }
        return scrapyardList;
    }


    public List<Vehicle> readVehicles(String fileName) throws IOException{
        try (Scanner scan = new Scanner(new File(fileName))){
            List<Vehicle> vehicleList = new ArrayList<>();
            int numberOfScrapyards = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < numberOfScrapyards; i++) {
                scan.nextLine();
                scan.nextLine();
                scan.nextLine();
                scan.nextLine();
                scan.nextLine();
            }
            int numberOfVehicles = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < numberOfVehicles; i++){
                int vehicleID = Integer.parseInt(scan.nextLine());
                int scrapyardID = Integer.parseInt(scan.nextLine());
                String type = scan.nextLine();
                String brand = scan.nextLine();
                String model = scan.nextLine();
                int yearModel = Integer.parseInt(scan.nextLine());
                String registrationNumber = scan.nextLine();
                String chassisNumber = scan.nextLine();
                String driveable = scan.nextLine();
                int numberOfSellableWheels = Integer.parseInt(scan.nextLine());

                switch (type) {
                    case "FossilCar" -> {
                        String fuelType = scan.nextLine();
                        int fuelAmount = Integer.parseInt(scan.nextLine());
                        vehicleList.add(new FossilCar(vehicleID, scrapyardID, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels, fuelType, fuelAmount));
                    }
                    case "ElectricCar" -> {
                         int batteryCapacity = Integer.parseInt(scan.nextLine());
                         int chargeLevel = Integer.parseInt(scan.nextLine());
                         vehicleList.add(new ElectricCar(vehicleID, scrapyardID, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels, batteryCapacity, chargeLevel));
                    }
                    case "Motorcycle" -> {
                        String hasSidecar = scan.nextLine();
                        int engineCapacity = Integer.parseInt(scan.nextLine());
                        String isModified = scan.nextLine();
                        int numberOfWheels = Integer.parseInt(scan.nextLine());
                        vehicleList.add(new Motorcycle(vehicleID, scrapyardID, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels, hasSidecar, engineCapacity, isModified, numberOfWheels));
                    }
                }
                scan.nextLine(); //hopp over ---
                }
            return vehicleList;
        }
    }
}
