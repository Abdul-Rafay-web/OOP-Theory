class Coaster extends Vehicle {
    private static final long serialVersionUID = 1L;
    private static final int TOTAL_SEATS = 32;
    private static final double BASE_FARE = 4000.0;

    public Coaster(String vehicleId, String model, boolean isAirConditioned, Driver driver,
                   Route route, String transporter, int facultySeatsCount) {
        super(vehicleId, model, TOTAL_SEATS, isAirConditioned, driver, route, transporter, facultySeatsCount);
    }

    @Override
    public double calculateBaseFare() {
        return BASE_FARE + (isAirConditioned ? 2000 : 0);
    }
}
