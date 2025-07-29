import java.io.Serializable;

abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String userId;
    protected String name;
    protected String contact;
    protected boolean hasActiveBooking;

    public User(String userId, String name, String contact) {
        this.userId = userId;
        this.name = name;
        this.contact = contact;
        this.hasActiveBooking = false;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public boolean hasActiveBooking() {
        return hasActiveBooking;
    }

    public void setHasActiveBooking(boolean hasActiveBooking) {
        this.hasActiveBooking = hasActiveBooking;
    }
    public abstract double calculateFare(Vehicle vehicle);

    @Override
    public String toString() {
        return "User [ID=" + userId + ", Name=" + name + ", Type=" + getClass().getSimpleName() +
                ", Contact=" + contact + ", Active Booking=" + hasActiveBooking + "]";
    }
}
