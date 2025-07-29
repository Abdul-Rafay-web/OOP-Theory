import java.io.*;
import java.util.*;

class Driver implements Serializable {
    private static final long serialVersionUID = 1L;
    private String driverId;
    private String name;
    private String licenseNumber;
    private String contact;
    private boolean assigned;

    public Driver(String driverId, String name, String licenseNumber, String contact) {
        this.driverId = driverId;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.contact = contact;
        this.assigned = false;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getContact() {
        return contact;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    @Override
    public String toString() {
        return "Driver [ID=" + driverId + ", Name=" + name + ", License=" + licenseNumber +
                ", Contact=" + contact + ", Status=" + (assigned ? "Assigned" : "Available") + "]";
    }
}
