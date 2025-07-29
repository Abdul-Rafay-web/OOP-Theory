import java.io.*;
import java.util.*;
abstract class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String vehicleId;
    protected String model;
    protected int totalSeats;
    protected boolean isAirConditioned;
    protected Driver driver;
    protected Route route;
    protected String transporter;

    protected boolean[] facultySeats;
    protected boolean[] studentSeats;

    public Vehicle(String vehicleId, String model, int totalSeats, boolean isAirConditioned,
                   Driver driver, Route route, String transporter, int facultySeatsCount) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.totalSeats = totalSeats;
        this.isAirConditioned = isAirConditioned;
        this.driver = driver;
        this.route = route;
        this.transporter = transporter;

        this.facultySeats = new boolean[facultySeatsCount];
        this.studentSeats = new boolean[totalSeats - facultySeatsCount];

        Arrays.fill(facultySeats, true);
        Arrays.fill(studentSeats, true);

        driver.setAssigned(true);
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public boolean isAirConditioned() {
        return isAirConditioned;
    }

    public Driver getDriver() {
        return driver;
    }

    public Route getRoute() {
        return route;
    }

    public String getTransporter() {
        return transporter;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public void setDriver(Driver driver) {
        if (this.driver != null) {
            this.driver.setAssigned(false);
        }

        this.driver = driver;
        driver.setAssigned(true);
    }

    public boolean bookFacultySeat(int seatNumber) throws SeatUnavailableException {
        if (seatNumber < 0 || seatNumber >= facultySeats.length) {
            throw new SeatUnavailableException("Invalid faculty seat number");
        }

        if (!facultySeats[seatNumber]) {
            throw new SeatUnavailableException("Faculty seat " + seatNumber + " already booked");
        }

        facultySeats[seatNumber] = false;
        return true;
    }
    public boolean bookStudentSeat(int seatNumber) throws SeatUnavailableException {
        if (seatNumber < 0 || seatNumber >= studentSeats.length) {
            throw new SeatUnavailableException("Invalid student seat number");
        }

        if (!studentSeats[seatNumber]) {
            throw new SeatUnavailableException("Student seat " + seatNumber + " already booked");
        }

        studentSeats[seatNumber] = false;
        return true;
    }
    public int getAvailableFacultySeats() {
        int count = 0;
        for (boolean seat : facultySeats) {
            if (seat) count++;
        }
        return count;
    }

    public int getAvailableStudentSeats() {
        int count = 0;
        for (boolean seat : studentSeats) {
            if (seat) count++;
        }
        return count;
    }

    public int getFacultySeatsCount() {
        return facultySeats.length;
    }

    public int getStudentSeatsCount() {
        return studentSeats.length;
    }

    public int getFirstAvailableFacultySeat() throws SeatUnavailableException {
        for (int i = 0; i < facultySeats.length; i++) {
            if (facultySeats[i]) return i;
        }
        throw new SeatUnavailableException("No faculty seats available");
    }

    public int getFirstAvailableStudentSeat() throws SeatUnavailableException {
        for (int i = 0; i < studentSeats.length; i++) {
            if (studentSeats[i]) return i;
        }
        throw new SeatUnavailableException("No student seats available");
    }

    public abstract double calculateBaseFare();

    @Override
    public String toString() {
        return "Vehicle [ID=" + vehicleId + ", Type=" + getClass().getSimpleName() +
                ", Model=" + model + ", Seats=" + totalSeats + ", AC=" + isAirConditioned +
                ", Transporter=" + transporter + ", Driver=" + driver.getName() +
                ", Route=" + route.getStartLocation() + " to " + route.getEndLocation() +
                ", Faculty Seats=" + getAvailableFacultySeats() + "/" + getFacultySeatsCount() +
                ", Student Seats=" + getAvailableStudentSeats() + "/" + getStudentSeatsCount() + "]";
    }
}
