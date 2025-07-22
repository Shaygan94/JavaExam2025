public abstract class Vehicle {
    private final int vehicleID;
    private final int scrapyardID;
    private final String brand;
    private final String model;
    private final int yearModel;
    private final String registrationNumber;
    private final String chassisNumber;
    private final String drivable;
    private final int numberOfSellableWheels;


    protected Vehicle(int vehicleID, int scrapyardID, String brand, String model, int yearModel, String registrationNumber, String chassisNumber, String drivable, int numberOfSellableWheels) {
        this.vehicleID = vehicleID;
        this.scrapyardID = scrapyardID;
        this.brand = brand;
        this.model = model;
        this.yearModel = yearModel;
        this.registrationNumber = registrationNumber;
        this.chassisNumber = chassisNumber;
        this.drivable = drivable;
        this.numberOfSellableWheels = numberOfSellableWheels;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public int getScrapyardID() {
        return scrapyardID;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearModel() {
        return yearModel;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public String getDrivable() {
        return drivable;
    }

    public int getNumberOfSellableWheels() {
        return numberOfSellableWheels;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID=" + vehicleID +
                ", scrapyardID=" + scrapyardID +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearModel=" + yearModel +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", drivable='" + drivable + '\'' +
                ", numberOfSellableWheels=" + numberOfSellableWheels +
                '}';
    }
}
