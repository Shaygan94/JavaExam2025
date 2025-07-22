public class SqlQueries {

    public static final String INSERT_SCRAPYARD_VALUES = "INSERT IGNORE INTO scrapyard (ScrapyardID, Name, Address, PhoneNumber) VALUES (?, ?, ?, ?)";
    public static final String INSERT_FOSSILCAR_VALUES = "INSERT IGNORE INTO fossilcar (vehicleID, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels, scrapyardID, fuelType, fuelAmount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String INSERT_ELECTRICCAR_VALUES = "INSERT IGNORE INTO electriccar (vehicleID, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels, scrapyardID, batteryCapacity, chargeLevel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String INSERT_MOTORCYCLE_VALUES = "INSERT IGNORE INTO motorcycle (vehicleID, brand, model, yearModel, registrationNumber, chassisNumber, driveable, numberOfSellableWheels, scrapyardID, hasSidecar, engineCapacity, isModified, numberOfWheels ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String SHOW_FOSSILCAR = "SELECT * FROM fossilcar";
    public static final String SHOW_ELECTRICCAR = "SELECT * FROM electriccar";
    public static final String SHOW_MOTORCYCLE = "SELECT * FROM motorcycle";

    public static final String TOTAL_FUEL_AMOUNT = "SELECT SUM(fuelAmount) AS totalFuel FROM fossilcar";

    public static final String ALL_DRIVEABLE_FOSSIL = "SELECT * FROM fossilcar WHERE driveable = 1";
    public static final String ALL_DRIVEABLE_ELECTRIC = "SELECT * FROM electriccar WHERE driveable = 1";
    public static final String ALL_DRIVEABLE_MOTORCYCLE = "SELECT * FROM motorcycle WHERE driveable = 1";

    public static final String ALL_FOSSILCAR_IN_SCRAPYARD_OSLO = "SELECT * FROM fossilcar WHERE scrapyardID = 1";
}