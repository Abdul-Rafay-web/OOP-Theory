
import java.util.*;
public class MainTransportManagementSystem{
    public static void main(String[] args) {
        TransportManagementSystem tms = new TransportManagementSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        try {
            tms.loadAllData();
        } catch (Exception e) {
            System.out.println("Starting with fresh data");
        }
        initializeSampleData(tms);

        while (running) {
            try {
                displayMainMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        handleUserManagement(scanner, tms);
                        break;
                    case 2:
                        handleDriverManagement(scanner, tms);
                        break;
                    case 3:
                        handleRouteManagement(scanner, tms);
                        break;
                    case 4:
                        handleVehicleManagement(scanner, tms);
                        break;
                    case 5:
                        handleBookingManagement(scanner, tms);
                        break;
                    case 6:
                        handleTransporterManagement(scanner, tms);
                        break;
                    case 7:
                        displayAllData(tms);
                        break;
                    case 8:
                        tms.saveAllData();
                        break;
                    case 9:
                        tms.loadAllData();
                        break;
                    case 0:
                        running = false;
                        tms.saveAllData();
                        System.out.println("Thank you for using Transport Management System. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();
    }
    private static void initializeSampleData(TransportManagementSystem tms) {
        try {
            tms.addTransporter("Nadeem Transporter", "0300-1234567", "Plot 12, Main Road, Karachi");
            tms.addTransporter("Zulfiqar Transporter", "0321-9876543", "Block 7, Clifton, Karachi");
            tms.addRoute("6B", "FAST-NUCES", "Gulshan", 15.5);
            tms.addRoute("12", "FAST-NUCES", "Defence", 18.2);
            tms.addRoute("19", "FAST-NUCES", "Clifton", 22.7);
            tms.addRoute("5B", "FAST-NUCES", "North Nazimabad", 30.1);
            tms.addDriver("D1", "Ali Ahmed", "LIC-12345", "0333-1234567");
            tms.addDriver("D2", "Bilal Khan", "LIC-23456", "0333-2345678");
            tms.addDriver("D3", "Kamran Shah", "LIC-34567", "0333-3456789");
            tms.addDriver("D4", "Danish Ali", "LIC-45678", "0333-4567890");
            tms.addBus("V1", "Hino Bus 2020", true, "D1", "R1", "Nadeem Transporter", 10);
            tms.addCoaster("V2", "Toyota Coaster 2021", true, "D2", "R2", "Nadeem Transporter", 8);
            tms.addBus("V3", "Hino Bus 2019", false, "D3", "R3", "Zulfiqar Transporter", 12);
            tms.addCoaster("V4", "Toyota Coaster 2022", false, "D4", "R4", "Zulfiqar Transporter", 6);
            tms.registerFaculty("F1", "Dr. Ahmed Khan", "0345-1234567", "Computer Science", "Professor");
            tms.registerFaculty("F2", "Ms. Sarah Ali", "0345-2345678", "Electrical Engineering", "Assistant Professor");
            tms.registerStudent("S1", "Hassan Ahmed", "0312-1234567", "21K-1234", "BCS", 3);
            tms.registerStudent("S2", "Fatima Khan", "0312-2345678", "21K-5678", "BEE", 4);
            tms.registerStudent("S3", "Usman Ali", "0312-3456789", "22K-1234", "BCS", 2);
        } catch (Exception e) {
            System.out.println("Error initializing sample data: " + e.getMessage());
        }
    }
    private static void displayMainMenu() {
        System.out.println("\n===== TRANSPORT MANAGEMENT SYSTEM =====");
        System.out.println("1. User Management");
        System.out.println("2. Driver Management");
        System.out.println("3. Route Management");
        System.out.println("4. Vehicle Management");
        System.out.println("5. Booking Management");
        System.out.println("6. Transporter Management");
        System.out.println("7. Display All Data");
        System.out.println("8. Save Data");
        System.out.println("9. Load Data");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
    public static void displayAllData(TransportManagementSystem tms) {
        tms.displayAllUsers();
        tms.displayAllDrivers();
        tms.displayAllRoutes();
        tms.displayAllVehicles();
        tms.displayAllBookings();
        tms.displayAllTransporters();
    }
    public static void handleUserManagement(Scanner scanner, TransportManagementSystem tms) {
        System.out.println("\n===== USER MANAGEMENT =====");
        System.out.println("1. Register Faculty");
        System.out.println("2. Register Student");
        System.out.println("3. Display All Users");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                registerFaculty(scanner, tms);
                break;
            case 2:
                registerStudent(scanner, tms);
                break;
            case 3:
                tms.displayAllUsers();
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    public  static void registerFaculty(Scanner scanner, TransportManagementSystem tms) {
        System.out.println("\n--- Register Faculty ---");
        System.out.print("Enter Faculty ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();

        tms.registerFaculty(userId, name, contact, department, designation);
        System.out.println("Faculty registered successfully!");
    }
    public static void registerStudent(Scanner scanner, TransportManagementSystem tms) {
        System.out.println("\n--- Register Student ---");
        System.out.print("Enter Student ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        String rollNumber = scanner.nextLine();

        System.out.print("Enter Program: ");
        String program = scanner.nextLine();

        System.out.print("Enter Semester: ");
        int semester = scanner.nextInt();
        scanner.nextLine();

        tms.registerStudent(userId, name, contact, rollNumber, program, semester);
        System.out.println("Student registered successfully!");
    }
    public  static void handleDriverManagement(Scanner scanner, TransportManagementSystem tms) {
        System.out.println("\n===== DRIVER MANAGEMENT =====");
        System.out.println("1. Add Driver");
        System.out.println("2. Display All Drivers");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                addDriver(scanner, tms);
                break;
            case 2:
                tms.displayAllDrivers();
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    private static void addDriver(Scanner scanner, TransportManagementSystem tms) {
        System.out.println("\n--- Add Driver ---");
        System.out.print("Enter Driver ID: ");
        String driverId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter License Number: ");
        String licenseNumber = scanner.nextLine();
        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();
        tms.addDriver(driverId, name, licenseNumber, contact);
        System.out.println("Driver added successfully!");
    }
    public static void handleRouteManagement(Scanner scanner, TransportManagementSystem tms) {
        System.out.println("\n===== ROUTE MANAGEMENT =====");
        System.out.println("1. Add Route");
        System.out.println("2. Display All Routes");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                addRoute(scanner, tms);
                break;
            case 2:
                tms.displayAllRoutes();
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    public static void addRoute(Scanner scanner, TransportManagementSystem tms) {
        System.out.println("\n--- Add Route ---");
        System.out.print("Enter Route ID: ");
        String routeId = scanner.nextLine();
        System.out.print("Enter Start Location: ");
        String startLocation = scanner.nextLine();
        System.out.print("Enter End Location: ");
        String endLocation = scanner.nextLine();
        System.out.print("Enter Distance (km): ");
        double distance = scanner.nextDouble();
        scanner.nextLine();
        tms.addRoute(routeId, startLocation, endLocation, distance);
        System.out.println("Route added successfully!");
    }
    public static void handleVehicleManagement(Scanner scanner, TransportManagementSystem tms) {
        System.out.println("\n===== VEHICLE MANAGEMENT =====");
        System.out.println("1. Add Bus");
        System.out.println("2. Add Coaster");
        System.out.println("3. Display All Vehicles");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addBus(scanner, tms);
                break;
            case 2:
                addCoaster(scanner, tms);
                break;
            case 3:
                tms.displayAllVehicles();
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    public static void addBus(Scanner scanner, TransportManagementSystem tms) {
        try {
            System.out.println("\n--- Add Bus ---");

            System.out.print("Enter Vehicle ID: ");
            String vehicleId = scanner.nextLine();

            System.out.print("Enter Model: ");
            String model = scanner.nextLine();

            System.out.print("Is Air Conditioned (true/false): ");
            boolean isAirConditioned = scanner.nextBoolean();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Driver ID: ");
            String driverId = scanner.nextLine();

            System.out.print("Enter Route ID: ");
            String routeId = scanner.nextLine();

            System.out.print("Enter Transporter Name: ");
            String transporterName = scanner.nextLine();

            System.out.print("Enter Number of Faculty Seats: ");
            int facultySeatsCount = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            tms.addBus(vehicleId, model, isAirConditioned, driverId, routeId, transporterName, facultySeatsCount);
            System.out.println("Bus added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void addCoaster(Scanner scanner, TransportManagementSystem tms) {
        try {
            System.out.println("\n--- Add Coaster ---");
            System.out.print("Enter Vehicle ID: ");
            String vehicleId = scanner.nextLine();
            System.out.print("Enter Model: ");
            String model = scanner.nextLine();
            System.out.print("Is Air Conditioned (true/false): ");
            boolean isAirConditioned = scanner.nextBoolean();
            scanner.nextLine();
            System.out.print("Enter Driver ID: ");
            String driverId = scanner.nextLine();
            System.out.print("Enter Route ID: ");
            String routeId = scanner.nextLine();
            System.out.print("Enter Transporter Name: ");
            String transporterName = scanner.nextLine();
            System.out.print("Enter Number of Faculty Seats: ");
            int facultySeatsCount = scanner.nextInt();
            scanner.nextLine();
            tms.addCoaster(vehicleId, model, isAirConditioned, driverId, routeId, transporterName, facultySeatsCount);
            System.out.println("Coaster added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void handleBookingManagement(Scanner scanner, TransportManagementSystem tms) {
        System.out.println("\n===== BOOKING MANAGEMENT =====");
        System.out.println("1. Create Booking");
        System.out.println("2. Complete Payment");
        System.out.println("3. Display All Bookings");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                createBooking(scanner, tms);
                break;
            case 2:
                completePayment(scanner, tms);
                break;
            case 3:
                tms.displayAllBookings();
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    public static void createBooking(Scanner scanner, TransportManagementSystem tms) {
        try {
            System.out.println("\n--- Create Booking ---");
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();
            System.out.print("Enter Vehicle ID: ");
            String vehicleId = scanner.nextLine();
            Booking booking = tms.createBooking(userId, vehicleId);
            System.out.println("Booking created successfully!");
            System.out.println("Booking Details: " + booking);
            System.out.println("Note: You must complete payment to confirm your booking.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void completePayment(Scanner scanner, TransportManagementSystem tms) {
        try {
            System.out.println("\n--- Complete Payment ---");

            System.out.print("Enter Booking ID: ");
            String bookingId = scanner.nextLine();

            tms.completePayment(bookingId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void handleTransporterManagement(Scanner scanner, TransportManagementSystem tms) {
        System.out.println("\n===== TRANSPORTER MANAGEMENT =====");
        System.out.println("1. Add Transporter");
        System.out.println("2. Display All Transporters");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                addTransporter(scanner, tms);
                break;
            case 2:
                tms.displayAllTransporters();
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    public static void addTransporter(Scanner scanner, TransportManagementSystem tms) {
        System.out.println("\n--- Add Transporter ---");
        System.out.print("Enter Transporter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        tms.addTransporter(name, contact, address);
        System.out.println("Transporter added successfully!");
    }
}
