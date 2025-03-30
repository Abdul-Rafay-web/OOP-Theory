package Q1;

import java.util.ArrayList;

public class Mentor {
    String mentorName;
    int mentorID;
    ArrayList<Student>assignedLearners;
    int maxLearners;
    ArrayList<Sport>sportExpertise;
    public Mentor() {
        this.mentorName="Unknown";
        this.mentorID=-1;
        this.assignedLearners=new ArrayList<>();
        this.sportExpertise=new ArrayList<>();
        this.maxLearners=0;
    }
    public Mentor(String mentorName,int mentorID,int maxLearners) {
        this.mentorName = mentorName;
        this.mentorID = mentorID;
        this.maxLearners = maxLearners;
        this.assignedLearners = new ArrayList<>();
    }
    public void assignLearners(Student student) {
        if (assignedLearners.size()<maxLearners) {
            this.assignedLearners.add(student);
        }
    }
    public void addSportExpertise(Sport sport){
        this.sportExpertise.add(sport);
    }
    public void removeLearners(Student student) {
                this.assignedLearners.remove(student);

            System.out.println("Removed "+student.studentID);
        }
    public void provideGuidance(){
        System.out.println("GUIDANCE :\n");
    }
    public void viewAssignedLearners() {
        System.out.println("Assigned Learners: " + this.assignedLearners);
    }
    public void viewMentorDetails(){
        System.out.println("Mentor Details");
        System.out.println("Name: " + this.mentorName);
        System.out.println("ID: " + this.mentorID);
        System.out.println("Sports Expertise: " + this.sportExpertise);
    }

}
