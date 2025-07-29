import java.io.*;
import java.util.*;
class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    private String bookingId;
    private User user;
    private Vehicle vehicle;
    private int seatNumber;
    private boolean isFacultySeat;
    private double fare;
    private boolean paymentComplete;
    private Date bookingDate;

    public Booking(String bookingId, User user, Vehicle vehicle, int seatNumber,
                   boolean isFacultySeat, double fare) {
        this.bookingId = bookingId;
        this.user = user;
        this.vehicle = vehicle;
        this.seatNumber = seatNumber;
        this.isFacultySeat = isFacultySeat;
        this.fare = fare;
        this.paymentComplete = false;
        this.bookingDate = new Date();
    }

    public String getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isFacultySeat() {
        return isFacultySeat;
    }

    public double getFare() {
        return fare;
    }

    public boolean isPaymentComplete() {
        return paymentComplete;
    }

    public void completePayment() {
        this.paymentComplete = true;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    @Override
    public String toString() {
        return "Booking [ID=" + bookingId + ", User=" + user.getName() +
                ", Vehicle=" + vehicle.getVehicleId() + ", Seat=" + seatNumber +
                " (" + (isFacultySeat ? "Faculty" : "Student") + ")" +
                ", Fare=Rs. " + fare + ", Payment=" + (paymentComplete ? "Complete" : "Pending") +
                ", Date=" + bookingDate + "]";
    }
}