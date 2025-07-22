import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {
    private final Connection con;

    public VehicleRepository(Connection con) {
        this.con = con;
    }

    public void insertVehicles(List<Vehicle> vehicle) throws SQLException {
        PreparedStatement stmtFossil = con.prepareStatement(SqlQueries.INSERT_FOSSILCAR_VALUES);
        PreparedStatement stmtElectric = con.prepareStatement(SqlQueries.INSERT_ELECTRICCAR_VALUES);
        PreparedStatement stmtMotorcycle = con.prepareStatement(SqlQueries.INSERT_MOTORCYCLE_VALUES);

        for (Vehicle v : vehicle) {
            if (v instanceof FossilCar fossilCar) {
                int driveable;
                if (fossilCar.getDrivable().equalsIgnoreCase("true")) {
                    driveable = 1;
                } else {
                    driveable = 0;
                }

                stmtFossil.setInt(1, fossilCar.getVehicleID());
                stmtFossil.setString(2, fossilCar.getBrand());
                stmtFossil.setString(3, fossilCar.getModel());
                stmtFossil.setInt(4, fossilCar.getYearModel());
                stmtFossil.setString(5, fossilCar.getRegistrationNumber());
                stmtFossil.setString(6, fossilCar.getChassisNumber());
                stmtFossil.setInt(7, driveable);
                stmtFossil.setInt(8, fossilCar.getNumberOfSellableWheels());
                stmtFossil.setInt(9, fossilCar.getScrapyardID());
                stmtFossil.setString(10, fossilCar.getFuelType());
                stmtFossil.setInt(11, fossilCar.getFuelAmount());
                stmtFossil.addBatch();
            } else if (v instanceof ElectricCar electricCar) {
                int driveable;
                if (electricCar.getDrivable().equalsIgnoreCase("true")) {
                    driveable = 1;
                } else {
                    driveable = 0;
                }
                stmtElectric.setInt(1, electricCar.getVehicleID());
                stmtElectric.setString(2, electricCar.getBrand());
                stmtElectric.setString(3, electricCar.getModel());
                stmtElectric.setInt(4, electricCar.getYearModel());
                stmtElectric.setString(5, electricCar.getRegistrationNumber());
                stmtElectric.setString(6, electricCar.getChassisNumber());
                stmtElectric.setInt(7, driveable);
                stmtElectric.setInt(8, electricCar.getNumberOfSellableWheels());
                stmtElectric.setInt(9, electricCar.getScrapyardID());
                stmtElectric.setInt(10, electricCar.getBatteryCapacity());
                stmtElectric.setInt(11, electricCar.getChargeLevel());
                stmtElectric.addBatch();
            } else if (v instanceof Motorcycle motorcycle) {
                int driveable;
                if (motorcycle.getDrivable().equalsIgnoreCase("true")) {
                    driveable = 1;
                } else {
                    driveable = 0;
                }

                int hasSideCar;
                if (motorcycle.getHasSidecar().equalsIgnoreCase("true")) {
                    hasSideCar = 1;
                } else {
                    hasSideCar = 0;
                }

                int isModified;
                if (motorcycle.getIsModified().equalsIgnoreCase("true")) {
                    isModified = 1;
                } else {
                    isModified = 0;
                }

                stmtMotorcycle.setInt(1, motorcycle.getVehicleID());
                stmtMotorcycle.setString(2, motorcycle.getBrand());
                stmtMotorcycle.setString(3, motorcycle.getModel());
                stmtMotorcycle.setInt(4, motorcycle.getYearModel());
                stmtMotorcycle.setString(5, motorcycle.getRegistrationNumber());
                stmtMotorcycle.setString(6, motorcycle.getChassisNumber());
                stmtMotorcycle.setInt(7, driveable);
                stmtMotorcycle.setInt(8, motorcycle.getNumberOfSellableWheels());
                stmtMotorcycle.setInt(9, motorcycle.getScrapyardID());
                stmtMotorcycle.setInt(10, hasSideCar);
                stmtMotorcycle.setInt(11, motorcycle.getEngineCapacity());
                stmtMotorcycle.setInt(12, isModified);
                stmtMotorcycle.setInt(13, motorcycle.getNumberOfWheels());
                stmtMotorcycle.addBatch();
            }

        }
        stmtFossil.executeBatch();
        stmtElectric.executeBatch();
        stmtMotorcycle.executeBatch();
    }


    public List<Vehicle> getAllFossil(String sqlQuery) throws SQLException {
        List<Vehicle> fossilCars = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement(sqlQuery);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String driveable;
            int driveableInt = rs.getInt("driveable");
            if (driveableInt == 1) {
                driveable = "true";
            } else {
                driveable = "false";
            }

            Vehicle fossilCar = new FossilCar(
                    rs.getInt("vehicleID"),
                    rs.getInt("scrapyardID"),
                    rs.getString("brand"),
                    rs.getString("model"),
                    rs.getInt("yearModel"),
                    rs.getString("registrationNumber"),
                    rs.getString("chassisNumber"),
                    driveable,
                    rs.getInt("numberOfSellableWheels"),
                    rs.getString("fuelType"),
                    rs.getInt("fuelAmount")

            );
            fossilCars.add(fossilCar);
        }
        return fossilCars;
    }


    public List<Vehicle> getAllElectric(String sqlQuery) throws SQLException {
        List<Vehicle> electricCars = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement(sqlQuery);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String driveable;
            int driveableInt = rs.getInt("driveable");
            if (driveableInt == 1) {
                driveable = "true";
            } else {
                driveable = "false";
            }

            Vehicle electricCar = new ElectricCar(
                    rs.getInt("vehicleID"),
                    rs.getInt("scrapyardID"),
                    rs.getString("brand"),
                    rs.getString("model"),
                    rs.getInt("yearModel"),
                    rs.getString("registrationNumber"),
                    rs.getString("chassisNumber"),
                    driveable,
                    rs.getInt("numberOfSellableWheels"),
                    rs.getInt("batteryCapacity"),
                    rs.getInt("chargeLevel")

            );
            electricCars.add(electricCar);
        }
        return electricCars;
    }

    public List<Vehicle> getAllMotorcycle(String sqlQuery) throws SQLException {
        List<Vehicle> motorcycles = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement(sqlQuery);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String driveable;
            int driveableInt = rs.getInt("driveable");
            if (driveableInt == 1) {
                driveable = "true";
            } else {
                driveable = "false";
            }

            String hasSidecar;
            int hasSidecarInt = rs.getInt("hasSidecar");
            if (hasSidecarInt == 1) {
                hasSidecar = "true";
            } else {
                hasSidecar = "false";
            }

            String isModified;
            int isModifiedInt = rs.getInt("isModified");
            if (isModifiedInt == 1) {
                isModified = "true";
            } else {
                isModified = "false";
            }

            Vehicle motorCycle = new Motorcycle(
                    rs.getInt("vehicleID"),
                    rs.getInt("scrapyardID"),
                    rs.getString("brand"),
                    rs.getString("model"),
                    rs.getInt("yearModel"),
                    rs.getString("registrationNumber"),
                    rs.getString("chassisNumber"),
                    driveable,
                    rs.getInt("numberOfSellableWheels"),
                    hasSidecar,
                    rs.getInt("engineCapacity"),
                    isModified,
                    rs.getInt("numberOfWheels")


            );
            motorcycles.add(motorCycle);
        }
        return motorcycles;
    }

    public int getTotalFuelAmount() throws SQLException {
        PreparedStatement stmt = con.prepareStatement(SqlQueries.TOTAL_FUEL_AMOUNT);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt("totalFuel");
        }
        return 0;
    }


}