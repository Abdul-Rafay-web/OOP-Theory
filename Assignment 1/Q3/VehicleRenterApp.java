package Q3;

import java.util.Scanner;

public class VehicleRenterApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Renter Name");
        String renterName = scan.nextLine();
        System.out.println("Enter the Renter License Type");
        String renterLicenseType = scan.nextLine();
        System.out.println("Enter the Renter Age");
        int renterAge = scan.nextInt();
        scan.nextLine();
        RentalSystem rentalSystem = new RentalSystem();
        Renter renter1 = new Renter(renterName,renterAge,renterLicenseType);
        rentalSystem.registerRenter(renter1);
        Renter renter2 = new Renter("Obaid",27,"Full");
        rentalSystem.registerRenter(renter2);
        Vehicle vehicle1=new Vehicle("Bike",1000,"Learner");
        Vehicle vehicle2=new Vehicle("Car",25000,"Intermediate");
        Vehicle vehicle3=new Vehicle("Truck",10000,"Full");
        rentalSystem.registerVehicle(vehicle1);
        rentalSystem.registerVehicle(vehicle2);
        rentalSystem.registerVehicle(vehicle3);
        rentalSystem.displayRenters();
        System.out.println("Enter the Renter ID ");
        int renterId = scan.nextInt();
        scan.nextLine();
        rentalSystem.displayVehicles();
        System.out.println("Enter Vehicle ID");
        int vehicleId = scan.nextInt();
        scan.nextLine();
        rentalSystem.rentVehicle(renterId,vehicleId);

    }
}
