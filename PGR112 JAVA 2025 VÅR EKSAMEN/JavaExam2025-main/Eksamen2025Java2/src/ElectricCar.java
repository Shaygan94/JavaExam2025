public class ElectricCar extends Vehicle {
    private final int batteryCapacity;
    private final int chargeLevel;


    protected ElectricCar(int vehicleID, int scrapyardID, String brand, String model, int yearModel, String registrationNumber, String chassisNumber, String drivable, int numberOfSellableWheels, int batteryCapacity, int chargeLevel) {
        super(vehicleID, scrapyardID, brand, model, yearModel, registrationNumber, chassisNumber, drivable, numberOfSellableWheels);
        this.batteryCapacity = batteryCapacity;
        this.chargeLevel = chargeLevel;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public int getChargeLevel() {
        return chargeLevel;
    }

    @Override
    public String toString() {
        return "ElectricCar{" +
                super.toString() +
                "batteryCapacity=" + batteryCapacity +
                ", chargeLevel=" + chargeLevel +
                "} ";
    }
}
