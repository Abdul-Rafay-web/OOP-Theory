class Student extends User {
    private static final long serialVersionUID = 1L;
    private String rollNumber;
    private String program;
    private int semester;

    public Student(String userId, String name, String contact, String rollNumber, String program, int semester) {
        super(userId, name, contact);
        this.rollNumber = rollNumber;
        this.program = program;
        this.semester = semester;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getProgram() {
        return program;
    }

    public int getSemester() {
        return semester;
    }

    @Override
    public double calculateFare(Vehicle vehicle) {
        // Students pay full fare
        return vehicle.calculateBaseFare();
    }

    @Override
    public String toString() {
        return super.toString() + " [Roll Number=" + rollNumber + ", Program=" + program +
                ", Semester=" + semester + "]";
    }
}