import java.util.*;
class TransportManagementSystem {
    private EntityList<User> users;
    private EntityList<Vehicle> vehicles;
    private EntityList<Driver> drivers;
    private EntityList<Route> routes;
    private EntityList<Booking> bookings;
    private EntityList<Transporter> transporters;

    public TransportManagementSystem() {
        users = new EntityList<>();
        vehicles = new EntityList<>();
        drivers = new EntityList<>();
        routes = new EntityList<>();
        bookings = new EntityList<>();
        transporters = new EntityList<>();
    }
    public void registerFaculty(String userId, String name, String contact,
                                String department, String designation) {
        Faculty faculty = new Faculty(userId, name, contact, department, designation);
        users.add(faculty);
    }

    public void registerStudent(String userId, String name, String contact,
                                String rollNumber, String program, int semester) {
        Student student = new Student(userId, name, contact, rollNumber, program, semester);
        users.add(student);
    }
    public void addDriver(String driverId, String name, String licenseNumber, String contact) {
        Driver driver = new Driver(driverId, name, licenseNumber, contact);
        drivers.add(driver);
    }
    public void addRoute(String routeId, String startLocation, String endLocation, double distance) {
        Route route = new Route(routeId, startLocation, endLocation, distance);
        routes.add(route);
    }
    public void addTransporter(String name, String contact, String address) {
        Transporter transporter = new Transporter(name, contact, address);
        transporters.add(transporter);
    }
    public void addBus(String vehicleId, String model, boolean isAirConditioned,
                       String driverId, String routeId, String transporterName, int facultySeatsCount)
            throws EntityNotFoundException {

        Driver driver = findDriverById(driverId);
        Route route = findRouteById(routeId);

        Bus bus = new Bus(vehicleId, model, isAirConditioned, driver, route,
                transporterName, facultySeatsCount);
        vehicles.add(bus);
    }

    public void addCoaster(String vehicleId, String model, boolean isAirConditioned,
                           String driverId, String routeId, String transporterName, int facultySeatsCount)
            throws EntityNotFoundException {

        Driver driver = findDriverById(driverId);
        Route route = findRouteById(routeId);

        Coaster coaster = new Coaster(vehicleId, model, isAirConditioned, driver, route,
                transporterName, facultySeatsCount);
        vehicles.add(coaster);
    }
    public Booking createBooking(String userId, String vehicleId)
            throws EntityNotFoundException, SeatUnavailableException,
            RoleBasedSeatViolationException {

        User user = findUserById(userId);
        Vehicle vehicle = findVehicleById(vehicleId);
        if (user.hasActiveBooking()) {
            throw new SeatUnavailableException("User already has an active booking");
        }

        String bookingId = "BK" + System.currentTimeMillis() % 10000;
        boolean isFacultySeat = false;
        int seatNumber = 0;
        if (user instanceof Faculty) {
            isFacultySeat = true;
            seatNumber = vehicle.getFirstAvailableFacultySeat();
        }
        else if (user instanceof Student) {
            isFacultySeat = false;
            seatNumber = vehicle.getFirstAvailableStudentSeat();
        }
        else {
            throw new RoleBasedSeatViolationException("Unknown user type");
        }
        double fare = user.calculateFare(vehicle);
        Booking booking = new Booking(bookingId, user, vehicle, seatNumber, isFacultySeat, fare);
        bookings.add(booking);
        user.setHasActiveBooking(true);

        return booking;
    }
    public void completePayment(String bookingId)
            throws EntityNotFoundException, SeatUnavailableException {

        Booking booking = findBookingById(bookingId);

        if (booking.isPaymentComplete()) {
            throw new SeatUnavailableException("Payment already completed");
        }
        booking.completePayment();
        Vehicle vehicle = booking.getVehicle();
        if (booking.isFacultySeat()) {
            vehicle.bookFacultySeat(booking.getSeatNumber());
        } else {
            vehicle.bookStudentSeat(booking.getSeatNumber());
        }

        System.out.println("Payment completed and seat booked for booking: " + bookingId);
    }
    private User findUserById(String userId) throws EntityNotFoundException {
        ArrayList<User> allUsers = users.getAll();
        for (User user : allUsers) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        throw new EntityNotFoundException("User not found with ID: " + userId);
    }

    private Driver findDriverById(String driverId) throws EntityNotFoundException {
        ArrayList<Driver> allDrivers = drivers.getAll();
        for (Driver driver : allDrivers) {
            if (driver.getDriverId().equals(driverId)) {
                return driver;
            }
        }
        throw new EntityNotFoundException("Driver not found with ID: " + driverId);
    }

    private Route findRouteById(String routeId) throws EntityNotFoundException {
        ArrayList<Route> allRoutes = routes.getAll();
        for (Route route : allRoutes) {
            if (route.getRouteId().equals(routeId)) {
                return route;
            }
        }
        throw new EntityNotFoundException("Route not found with ID: " + routeId);
    }

    private Vehicle findVehicleById(String vehicleId) throws EntityNotFoundException {
        ArrayList<Vehicle> allVehicles = vehicles.getAll();
        for (Vehicle vehicle : allVehicles) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        throw new EntityNotFoundException("Vehicle not found with ID: " + vehicleId);
    }

    private Booking findBookingById(String bookingId) throws EntityNotFoundException {
        ArrayList<Booking> allBookings = bookings.getAll();
        for (Booking booking : allBookings) {
            if (booking.getBookingId().equals(bookingId)) {
                return booking;
            }
        }
        throw new EntityNotFoundException("Booking not found with ID: " + bookingId);
    }
    public void displayAllUsers() {
        System.out.println("\n===== USERS =====");
        ArrayList<User> allUsers = users.getAll();
        for (User user : allUsers) {
            System.out.println(user);
        }
    }

    public void displayAllDrivers() {
        System.out.println("\n===== DRIVERS =====");
        ArrayList<Driver> allDrivers = drivers.getAll();
        for (Driver driver : allDrivers) {
            System.out.println(driver);
        }
    }
    public void displayAllRoutes() {
        System.out.println("\n===== ROUTES =====");
        ArrayList<Route> allRoutes = routes.getAll();
        for (Route route : allRoutes) {
            System.out.println(route);
        }
    }
    public void displayAllVehicles() {
        System.out.println("\n===== VEHICLES =====");
        ArrayList<Vehicle> allVehicles = vehicles.getAll();
        for (Vehicle vehicle : allVehicles) {
            System.out.println(vehicle);
        }
    }
    public void displayAllBookings() {
        System.out.println("\n===== BOOKINGS =====");
        ArrayList<Booking> allBookings = bookings.getAll();
        for (Booking booking : allBookings) {
            System.out.println(booking);
        }
    }

    public void displayAllTransporters() {
        System.out.println("\n===== TRANSPORTERS =====");
        ArrayList<Transporter> allTransporters = transporters.getAll();
        for (Transporter transporter : allTransporters) {
            System.out.println(transporter);
        }
    }
    public void saveAllData() {
        users.saveToFile("users.txt");
        drivers.saveToFile("drivers.txt");
        routes.saveToFile("routes.txt");
        vehicles.saveToFile("vehicles.txt");
        bookings.saveToFile("bookings.txt");
        transporters.saveToFile("transporters.txt");
    }
    public void loadAllData() {
        users.loadFromFile("users.txt");
        drivers.loadFromFile("drivers.txt");
        routes.loadFromFile("routes.txt");
        vehicles.loadFromFile("vehicles.txt");
        bookings.loadFromFile("bookings.txt");
        transporters.loadFromFile("transporters.txt");
    }
}