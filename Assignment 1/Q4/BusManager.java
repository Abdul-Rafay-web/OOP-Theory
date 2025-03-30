package Q4;

import java.util.ArrayList;

public class BusManager {
    String managerName;
    private final long busFee = 39500;
    private static int maxStudents=50;
    ArrayList<BusRoute> busRoutes;
    ArrayList<Student> students;

    public BusManager() {
        this.managerName = "BusManager";
        this.busRoutes = new ArrayList<>();
        this.students = new ArrayList<>();
    }
public void stop(BusRoute busRoute) {
        busRoutes.add(busRoute);
}
public void addStudent(Student student) {
        students.add(student);
}
    public void registerBusRoute(String routeName, String studentName) {
        boolean foundRoute = false;
        boolean foundStudent = false;
        for (BusRoute busRoute : busRoutes) {
            if (busRoute.routeName.equals(routeName)) {
                foundRoute = true;
                busRoute.totalStudents++;

                for (Student student : students) {
                    if (student.studentName.equals(studentName)) {
                        student.feePaid = true;
                        foundStudent = true;
                        System.out.println("Successfully registered for bus route " + busRoute.routeName);
                        break;
                    }
                }
                break;
            }
        }

        if (!foundRoute) {
            System.out.println("Bus Route " + routeName + " not found.");
        } else if (!foundStudent) {
            System.out.println("Student " + studentName + " not found.");
        }
    }


    public void markAttendance(String studentName) {
        for (Student student1 : students) {
            int studentFound = 0;
            if (student1.studentName.equals(student1.studentName)) {
                studentFound = 1;
                student1.attendance = true;
                System.out.println("Successfully marked attendance for student " + student1.studentName);
                break;
            }
        }
    }

        public void payFee(double fee,String routeName,String studentName) {
            if (maxStudents<=50){
                if (fee >= busFee) {
                    for (BusRoute busRoute : busRoutes) {
                        if (busRoute.routeName.equals(routeName)) {
                            for (Student student : students) {
                                if (student.studentName.equals(studentName)) {
                                    student.feePaid = true;
                                }
                            }
                            busRoute.totalStudents++;
                            break;
                        }
                    }
                    double remaining=fee-this.busFee;
                    System.out.println("Fee is paid.Collect Remaining amount:Rs. "+remaining);
                }else{
                    System.out.println("Insufficient fee");
                }
            }else{
                System.out.println("Maximum number of students reached cannot ");
            }
        }
}
