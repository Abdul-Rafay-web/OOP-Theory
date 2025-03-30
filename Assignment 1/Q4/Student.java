package Q4;

public class Student {
    String studentName;
    int studentAge;
    boolean feePaid;
    boolean attendance=false;
    public Student(String studentName, int studentAge) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.feePaid = false;
    }
    public String getStudentName() {
        return studentName;
    }
    public void payTransportFee(){
        this.feePaid = true;
    }
public void studentStatus(){
        System.out.println("Name: "+this.studentName);
        System.out.println("Age: "+this.studentAge);
        if(feePaid){
            System.out.println("Fee Paid: Yes");
        }else{

            System.out.println("Fee Paid: No");
        }
        System.out.println("Attendance: "+this.attendance);
}
}
