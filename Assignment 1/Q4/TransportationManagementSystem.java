package Q4;

import java.util.Scanner;

public class TransportationManagementSystem {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the name of the student");
        String studentName=scan.nextLine();
        System.out.println("Enter the Age of the student");
        int studentAge=scan.nextInt();
        Student student2=new Student("Owais",18);
        BusRoute busRoute1=new BusRoute();
        busRoute1.addBusRoute("Clifton",34);
        BusRoute busRoute2=new BusRoute();
        busRoute2.addBusRoute("Nipa",48);
        Student student1=new Student(studentName,studentAge);
        BusManager manager1=new BusManager();
        manager1.addStudent(student1);
        manager1.addStudent(student2);
        manager1.stop(busRoute1);
        manager1.stop(busRoute2);
        scan.nextLine();
        System.out.println("Enter the Stop Name");
        String stopName=scan.nextLine();
        manager1.registerBusRoute(stopName,student1.studentName);
        System.out.println("Enter the Amount you want to pay");
        double amount=scan.nextDouble();
        scan.nextLine();
        System.out.println("Enter the Route name");
        String routeName=scan.nextLine();
        manager1.payFee(amount,routeName,student1.studentName);
        System.out.println("Tap on the Student Name to mark Attendance");
        String sName=scan.nextLine();
        manager1.markAttendance(sName);
        manager1.registerBusRoute(busRoute1.routeName,student2.studentName);
        manager1.payFee(39500,"Clifton",student2.studentName);
        System.out.println("Students Status");
        student1.studentStatus();
        System.out.println("Bus Route : "+busRoute2.getBusRoute());
        student2.studentStatus();
        System.out.println("Bus Route : "+busRoute1.getBusRoute());
    }
}
