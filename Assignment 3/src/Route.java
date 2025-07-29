import java.io.*;
import java.util.*;
class Route implements Serializable {
    private static final long serialVersionUID = 1L;
    private String routeId;
    private String startLocation;
    private String endLocation;
    private double distance; // in kilometers
    private static final double LONG_DISTANCE_THRESHOLD = 25.0; // 25 km threshold

    public Route(String routeId, String startLocation, String endLocation, double distance) {
        this.routeId = routeId;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = distance;
    }

    public String getRouteId() {
        return routeId;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public double getDistance() {
        return distance;
    }

    public boolean isLongDistance() {
        return distance > LONG_DISTANCE_THRESHOLD;
    }

    @Override
    public String toString() {
        return "Route [ID=" + routeId + ", From=" + startLocation + ", To=" + endLocation +
                ", Distance=" + distance + "km, " + (isLongDistance() ? "Long Distance" : "Short Distance") + "]";
    }
}