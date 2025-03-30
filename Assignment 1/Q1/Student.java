package Q1;

import java.util.ArrayList;

public class Student {
    String studentName;
    int studentID;
    int studentAge;
    ArrayList<String>sportsInterests;
    Mentor mentorAssigned;
    public Student(String studentName,int studentID,int studentAge) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.studentAge = studentAge;
        sportsInterests = new ArrayList<>();
    }

    public Student() {
        this.studentName = "";
        this.studentID = 0;
        this.studentAge = 0;
        sportsInterests = new ArrayList<>();
    }

    public void registerForMentorShip(Mentor mentor) {
        this.mentorAssigned = mentor;
    }
    public void updateSportsInterest(String sportsInterest) {
        sportsInterests.add(sportsInterest);
    }
    public void viewMentorDetails()
    {
        System.out.println("Name: " + mentorAssigned.mentorName);
        System.out.println("ID: " + mentorAssigned.mentorID);
        System.out.println("Max Learners: "+mentorAssigned.maxLearners);
    }



}
