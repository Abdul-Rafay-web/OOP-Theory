package Q3;

import Q2.Team;

import javax.sound.midi.MidiFileFormat;
import java.util.ArrayList;

public class RentalSystem {
    ArrayList<Renter>renters=new ArrayList<>();
    ArrayList<Vehicle>vehicles=new ArrayList<>();
    public void registerRenter(Renter renter) {
        renters.add(renter);
    }
    public void registerVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    public void displayRenters() {
        for (Renter r : renters) {
            r.displayRenterDetails();
        }
    }
    public void displayVehicles() {
        for (Vehicle v : vehicles) {
            v.displayVehicleDetails();
        }
    }

    public void rentVehicle(int renterId, int vehicleId) {
        if (renterId > 0 && renterId <= renters.size() && vehicleId > 0 && vehicleId <= vehicles.size()) {
            Renter renter = renters.get(renterId - 1);
            Vehicle vehicle = vehicles.get(vehicleId - 1);

            // Check if renter is eligible for the selected vehicle
            if (vehicle.isEligible(renter.renterLicense)) {
                System.out.println("The Renter " + renter.renterName + " is eligible for Vehicle " + vehicle.vehicleModel);
            } else {
                System.out.println("Sorry, you are not eligible for Vehicle " + vehicle.vehicleModel);
            }
        } else {
            System.out.println("Invalid renter or vehicle ID.");
        }
    }

}
