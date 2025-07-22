public class Motorcycle extends Vehicle{
    private final String hasSidecar;
    private final int engineCapacity;
    private final String isModified;
    private final int numberOfWheels;


    protected Motorcycle(int vehicleID, int scrapyardID, String brand, String model, int yearModel, String registrationNumber, String chassisNumber, String drivable, int numberOfSellableWheels, String hasSidecar, int engineCapacity, String isModified, int numberOfWheels) {
        super(vehicleID, scrapyardID, brand, model, yearModel, registrationNumber, chassisNumber, drivable, numberOfSellableWheels);
        this.hasSidecar = hasSidecar;
        this.engineCapacity = engineCapacity;
        this.isModified = isModified;
        this.numberOfWheels = numberOfWheels;
    }

    public String getHasSidecar() {
        return hasSidecar;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public String getIsModified() {
        return isModified;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                super.toString() +
                "hasSidecar='" + hasSidecar + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", isModified='" + isModified + '\'' +
                ", numberOfWheels=" + numberOfWheels +
                "} ";
    }
}
