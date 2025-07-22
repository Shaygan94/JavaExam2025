import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args){
        ConnectToDatabase connect = new ConnectToDatabase();
        try{
            connect.connectToDatabase();
            System.out.println("Connected to scrapyard.database");
        } catch (SQLException e) {
            System.out.println("Error with connecting to scrapyard.database " + e.getMessage());
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Error with reading file db.properties " + e.getMessage());
            e.printStackTrace();
        }
        ScrapyardRepository scrapyardRepository = new ScrapyardRepository(connect.getCon());
        VehicleRepository vehicleRepository = new VehicleRepository(connect.getCon());


        FileHandler fh = new FileHandler();
        try {
            List<Scrapyard> scrapyardList = fh.readScrapyard("vehicles.txt");

            try{
                scrapyardRepository.insertScrapyardValuesToDB(scrapyardList);
            } catch (SQLException e) {
                System.out.println("Issue with inserting scrapyard values from vehicles to db " + e.getMessage());
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("Error reading scrapyard values from vehicles.txt "+ e.getMessage());
            e.printStackTrace();
        }

        try{
           List<Vehicle> vehicleList =  fh.readVehicles("vehicles.txt");
           vehicleRepository.insertVehicles(vehicleList);
        } catch (IOException e) {
            System.out.println("Issues with reading vehicles from vehicles.txt " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error inserting vehicle values from vehicle.txt to database " + e.getMessage());
            e.printStackTrace();
        }


        Menu menu = new Menu(vehicleRepository);
        menu.menu();

    }


}
