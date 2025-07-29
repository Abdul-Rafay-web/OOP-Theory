class Faculty extends User {
    private static final long serialVersionUID = 1L;
    private String department;
    private String designation;

    public Faculty(String userId, String name, String contact, String department, String designation) {
        super(userId, name, contact);
        this.department = department;
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public double calculateFare(Vehicle vehicle) {
        // Faculty gets 15% discount
        double baseFare = vehicle.calculateBaseFare();
        return baseFare * 0.85;
    }

    @Override
    public String toString() {
        return super.toString() + " [Department=" + department + ", Designation=" + designation + "]";
    }
}