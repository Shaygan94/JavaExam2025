public class FossilCar extends Vehicle{
    private final String fuelType;
    private final int fuelAmount;


    protected FossilCar(int vehicleID, int scrapyardID, String brand, String model, int yearModel, String registrationNumber, String chassisNumber, String drivable, int numberOfSellableWheels, String fuelType, int fuelAmount) {
        super(vehicleID, scrapyardID, brand, model, yearModel, registrationNumber, chassisNumber, drivable, numberOfSellableWheels);
        this.fuelType = fuelType;
        this.fuelAmount = fuelAmount;
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getFuelAmount() {
        return fuelAmount;
    }

    @Override
    public String toString() {
        return "FossilCar{" +
                 super.toString() +
                "fuelType='" + fuelType + '\'' +
                ", fuelAmount=" + fuelAmount +
                "} " ;
    }
}
