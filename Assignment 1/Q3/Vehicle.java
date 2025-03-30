package Q3;

import java.util.ArrayList;

public class Vehicle {
    String vehicleModel;
    double pricePerDay;
    ArrayList<String>eligibleVehicles;

    public Vehicle(String vehicleModel, double pricePerDay,String vehicleLicenseType) {
        this.vehicleModel=vehicleModel;
        this.pricePerDay=pricePerDay;
        this.eligibleVehicles=new ArrayList<>();
        eligibleVehicles.add(vehicleLicenseType);
    }

    public boolean isEligible(String renterLicense) {
        return eligibleVehicles.contains(renterLicense);
    }
    public void displayVehicleDetails() {
        System.out.println(this.vehicleModel);
        System.out.println(this.pricePerDay);
    }
}