import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Menu implements MenuInterface{
    private VehicleRepository vehicleRepository;

    public Menu(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void menu(){
        int choice = 0;
        Scanner scan = new Scanner(System.in);
        while (choice != 5){
            System.out.println("1. See all info of about all vehicles registered in database");
            System.out.println("2. Show total amount of fuel found in Fossil cars");
            System.out.println("3. Show all vehicles that are driveAble");
            System.out.println("4  Show all fossilCars registered in Oslo");
            System.out.println("5. Exit.");
            choice = scan.nextInt();
            switch (choice){
                case 1 -> showAllInfoAllVehicles();
                case 2 -> showTotalAmountOfFuel();
                case 3 -> showDriveableVehicles();
                case 4 -> showFossilInScrapyardOslo();
                case 5 -> quit();
                default -> System.out.println("Invalid input. You need to choose between 1-4..");
            }

        }
    }
    @Override
    public void showFossilInScrapyardOslo() {
        try {
            List<Vehicle> fossilInOslo = vehicleRepository.getAllFossil(SqlQueries.ALL_FOSSILCAR_IN_SCRAPYARD_OSLO);
            System.out.println("Showing all fossil cars in Scrapyard Oslo");
            for (Vehicle f : fossilInOslo){
                System.out.println(f);
            }
        } catch (SQLException e) {
            System.out.println("Error with getting all fossilCars with scrapYard id = 1 " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void quit() {
        System.out.println("Quitting.... GoodBye!");
    }
    @Override
    public void showDriveableVehicles() {

        try{
            System.out.println("-------------------------------------------");
            System.out.println("Showing driveable fossil cars: ");
            List<Vehicle> driveableFossilCars = vehicleRepository.getAllFossil(SqlQueries.ALL_DRIVEABLE_FOSSIL);
            for (Vehicle f : driveableFossilCars){
                System.out.println(f);
            }
        } catch (SQLException e) {
            System.out.println("Error getting all driveAble fossilCars " + e.getMessage());
            e.printStackTrace();
        }

        try{
            System.out.println("-------------------------------------------");
            System.out.println("Showing driveable Electric cars: ");
            List<Vehicle> driveableElectricCars = vehicleRepository.getAllElectric(SqlQueries.ALL_DRIVEABLE_ELECTRIC);
            for (Vehicle e : driveableElectricCars){
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println("Error getting all driveAble electricCars" + e.getMessage());
            e.printStackTrace();
        }
        try{
            System.out.println("-------------------------------------------");
            System.out.println("Showing driveable Motorcycles: ");
            List<Vehicle> driveableMotorcycles = vehicleRepository.getAllMotorcycle(SqlQueries.ALL_DRIVEABLE_MOTORCYCLE);
            for (Vehicle m : driveableMotorcycles){
                System.out.println(m);
            }
        } catch (SQLException e) {
            System.out.println("Error getting all driveAble motorcycles " + e.getMessage());
            e.printStackTrace();
        }


    }
   @Override
   public void showTotalAmountOfFuel() {
        try{
            int totalFuel = vehicleRepository.getTotalFuelAmount();
            System.out.println("Showing total fuel in fossil cars: " + totalFuel +  " litres");
        } catch (SQLException e) {
            System.out.println("Error getting total amount of fuel from database " + e.getMessage());
            e.printStackTrace();
        }
    }
    @Override
    public void showAllInfoAllVehicles() {
        try {
            List<Vehicle> fossilCars = vehicleRepository.getAllFossil(SqlQueries.SHOW_FOSSILCAR);
            System.out.println("-------------------------------------------");
            System.out.println("Showing all Fosssil Cars: ");
            for (Vehicle f : fossilCars) {
                System.out.println(f);
            }
        } catch (SQLException e) {
            System.out.println("Error with SQL-query getting all info about fossilcars " + e.getMessage());
            e.printStackTrace();
        }
        try{
            List<Vehicle> electricCars = vehicleRepository.getAllElectric(SqlQueries.SHOW_ELECTRICCAR);
            System.out.println("-------------------------------------------");
            System.out.println("Showing all Electric Cars: ");
            for (Vehicle e : electricCars){
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println("Error with SQL-query getting all info about electricCars "+ e.getMessage());
            e.printStackTrace();
        }

        try{
            List<Vehicle> motorCycles = vehicleRepository.getAllMotorcycle(SqlQueries.SHOW_MOTORCYCLE);
            System.out.println("-------------------------------------------");
            System.out.println("Showing all Motorcycles: ");
            for(Vehicle m : motorCycles){
                System.out.println(m);
            }
        } catch (SQLException e) {
            System.out.println("Error with SQL-query getting all info about motorcycles "+ e.getMessage());
            e.printStackTrace();
        }
    }

}
