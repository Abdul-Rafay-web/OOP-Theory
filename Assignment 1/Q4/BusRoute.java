package Q4;

import java.util.ArrayList;

public class BusRoute {
    String routeName;
    int totalStudents;
    public void addBusRoute(String busRoute,int totalStudents) {
        this.routeName = busRoute;
        this.totalStudents=totalStudents;
    }
    void displayBusRoute() {
        System.out.println("Route Name: "+this.routeName);
        System.out.println("Present Students: "+this.totalStudents);
    }
    public String getBusRoute(){
        return this.routeName;
    }
}
