package Q1;

import java.util.ArrayList;
import java.util.Scanner;

public class SportsManagementSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Mentor> mentors = new ArrayList<>();
        ArrayList<Sport> sports = new ArrayList<>();
        ArrayList<Skill> skills = new ArrayList<>();
        int roleChoice;
        int studentFound = 0;
        int mentorFound = 0;
        do {
            System.out.println("Choose your Role\n1.Student     2.Mentor     3.Sports     4.Skills     5.Exit");
            roleChoice = scan.nextInt();
            switch (roleChoice) {
                case 1:
                    scan.nextLine();
                    System.out.println("1.Add Student Details\n2.Register for MentorShip\n3.Update Sport Interest\n4.View Mentor Details\n5.Exit");
                    int choice;
                    choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                            scan.nextLine();
                            System.out.println("Enter the name of the Student");
                            String studentName = scan.nextLine();
                            System.out.println("Enter the ID of the Student");
                            int studentID = scan.nextInt();
                            System.out.println("Enter the Age of the Student");
                            int age = scan.nextInt();
                            scan.nextLine();
                            students.add(new Student(studentName, studentID, age));
                            break;
                        case 2:scan.nextLine();
                            System.out.println("Enter the Name of the Mentor");
                            String mentorName = scan.nextLine();
                            System.out.println("Enter the ID of the Student");
                            int sID = scan.nextInt();
                            scan.nextLine();
                            for (Mentor mentor : mentors) {
                                if (mentor.mentorName.equals(mentorName)) {
                                    mentorFound = 1;
                                    for (Student student : students) {
                                        if (student.studentID == sID) {
                                            studentFound = 1;
                                            student.registerForMentorShip(mentor);
                                            System.out.println("Successfully registered for the Mentorship of " + mentor.mentorName);
                                            break;
                                        }
                                    }
                                }
                            }
                            if (studentFound == 0 || mentorFound == 0) {
                                System.out.println("Invalid Mentor or Student details entered");
                            }
                            break;
                        case 3:
                            scan.nextLine();
                            System.out.println("Enter the ID of the Student");
                            int s_id = scan.nextInt();
                            scan.nextLine();
                            studentFound = 0;
                            for (Student student : students) {
                                if (student.studentID == s_id) {
                                    studentFound = 1;
                                    System.out.println("Enter the Name of the Sport Interest");
                                    String sportInterest = scan.nextLine();
                                    student.updateSportsInterest(sportInterest);
                                }
                            }
                            if (studentFound==0) {
                                System.out.println("Student not found");
                            }
                            break;
                        case 4:
                            if (mentors.isEmpty()) {
                                System.out.println("No Mentors found");
                            } else {
                                for (Mentor mentor : mentors) {
                                    mentor.viewMentorDetails();
                                }
                            }
                            break;
                        case 5:
                            System.out.println("Returning back to the Role Menu");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1.Add Mentor Details\n2.Assign A Learner\n3.Add Sports Expertise\n4.View Learners\n5.Remove a Learner\n6.Exit");
                    int choice2 = scan.nextInt();
                    scan.nextLine();
                    switch (choice2) {
                        case 1:
                            System.out.println("Enter the name of the Mentor");
                            String mentorName = scan.nextLine();
                            System.out.println("Enter the ID of the Mentor");
                            int mentorID = scan.nextInt();
                            System.out.println("Enter the Maximum Learners of the Mentor");
                            int maxLearners = scan.nextInt();
                            mentors.add(new Mentor(mentorName, mentorID, maxLearners));
                            System.out.println("Successfully registered for the Mentor " + mentorName);
                            break;
                        case 2:
                            System.out.println("Enter the ID of the Mentor");
                            int m_id = scan.nextInt();
                            System.out.println("Enter the Name of the Learner");
                            String learnerName = scan.nextLine();
                            System.out.println("Enter the ID of the Learner");
                            int learnerID = scan.nextInt();
                            System.out.println("Enter the age of the Student");
                            int LearnerAge = scan.nextInt();
                            mentorFound = 0;
                            for (Mentor mentor : mentors) {
                                if (mentor.mentorID == m_id) {
                                    mentorFound = 1;
                                    mentor.assignLearners(new Student(learnerName, learnerID, LearnerAge));
                                    System.out.println("Successfully registered for the Mentor " + mentor.mentorName);
                                    break;
                                }
                            }
                            if (mentorFound == 0) {
                                System.out.println("The Mentor is not found");
                            }
                            break;
                        case 3:
                            System.out.println("Enter the ID of the Mentor");
                            int men_id = scan.nextInt();
                            scan.nextLine();
                            for (Mentor mentor : mentors) {
                                if (mentor.mentorID == men_id) {
                                    System.out.println("Enter the name of the Sport");
                                    String sport = scan.nextLine();
                                    System.out.println("Enter the ID of the Sport");
                                    int sportID = scan.nextInt();
                                    System.out.println("Enter the Description of the Sports");
                                    String sportDescription = scan.nextLine();
                                    mentor.addSportExpertise(new Sport(sport, sportID, sportDescription));
                                    System.out.println("The Sports Expertise has been Added Successfully");
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Enter the Mentor ID");
                            int id = scan.nextInt();
                            scan.nextLine();
                            mentorFound = 0;
                            for (Mentor mentor : mentors) {
                                if (mentor.mentorID == id) {
                                    mentorFound = 1;
                                    mentor.viewAssignedLearners();
                                }
                            }
                            if (mentorFound == 0) {
                                System.out.println("The Mentor is not found");
                            }
                            break;
                        case 5:
                            System.out.println("Enter the ID of the Mentor");
                            int mentor_id = scan.nextInt();
                            scan.nextLine();
                            studentFound = 0;
                            mentorFound = 0;
                            for (Mentor mentor : mentors) {
                                if (mentor.mentorID == mentor_id) {
                                    mentorFound = 1;
                                    System.out.println("Enter the Name of the Learner");
                                    int s_id = scan.nextInt();
                                    for (Student student : students) {
                                        if (student.studentID == s_id) {
                                            studentFound = 1;
                                            mentor.removeLearners(student);
                                        }
                                    }
                                }
                            }
                            if (studentFound == 0 || mentorFound == 0) {
                                System.out.println("The Mentor or Student is not found");
                            }
                            break;
                        case 6:
                            System.out.println("Exiting to the Role Menu.....");
                    }
                    break;
                case 3:
                    scan.nextLine();
                    System.out.println("1.Add Sports Details\n2.Add Required Skills\n3.Remove Required Skills\n4.Exit");
                    int choice3 = scan.nextInt();
                    switch (choice3) {
                        case 1:
                            System.out.println("Enter the Sport Name");
                            String sportName = scan.nextLine();
                            System.out.println("Enter the ID of the Sport");
                            int sportID = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Enter the Description of the Sport");
                            String sportDescription = scan.nextLine();
                            sports.add(new Sport(sportName, sportID, sportDescription));
                            System.out.println("The Sports" + sportName + "has been Added Successfully");
                            break;
                        case 2:
                            System.out.println("Enter the ID of the Sport");
                            int s_id=scan.nextInt();
                            for (Sport sport : sports) {
                                if (sport.sportID==s_id) {
                                    System.out.println("Enter the Required Skill Name");
                                    String requiredSkill = scan.nextLine();
                                    System.out.println("Enter the Skill ID of the Sport");
                                    int skillID = scan.nextInt();
                                    scan.nextLine();
                                    System.out.println("Enter the Description of the Skill");
                                    String skillDescription=scan.nextLine();
                                    sport.addRequiredSkill(new Skill(requiredSkill,skillID,skillDescription));
                                    break;
                                }
                            }
                            break;
                            case 3:System.out.println("Enter the ID of the Sport");
                            int sport_id=scan.nextInt();
                            for (Sport sport : sports) {
                                if (sport.sportID==sport_id) {
                                    sports.remove(sport);
                                    break;
                                }
                            }
                            break;
                            case 4:System.out.println("Exiting to the Role Menu.....");
                            break;
                    }
                    break;
                case 4:scan.nextLine();
                System.out.println("1.Add Skill Details\n2.Update Skill Description\n3.Show Skill Details\n4.Exit");
                int choice4 = scan.nextInt();
                scan.nextLine();
                switch (choice4) {
                    case 1:System.out.println("Enter the Skill Name");
                    String skillName = scan.nextLine();
                    System.out.println("Enter the ID of the Skill");
                    int skillID = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter the Description of the Skill");
                    String skillDescription=scan.nextLine();
                    skills.add(new Skill(skillName, skillID, skillDescription));
                    System.out.println("The Skills" + skillName + "has been Added Successfully");
                    break;
                    case 2:System.out.println("Enter the ID of the Skill");
                    int skill_id=scan.nextInt();
                    for (Skill skill : skills) {
                        if (skill.skillID==skill_id) {
                            System.out.println("Enter the Updated Skill Description");
                            String updatedSkillDescription=scan.nextLine();
                            skill.updateSkillDescription(updatedSkillDescription);
                            System.out.println("THe skill description has been updated Successfully");
                            break;
                        }
                    }
                    break;
                    case 3:System.out.println("Enter the ID of the Skill");
                    int s_id=scan.nextInt();
                    for (Skill skill : skills) {
                        if (skill.skillID==s_id) {
                            skill.showSkillDescription();
                        }
                    }
                    break;
                    case 4:System.out.println("Returning back to the Choice Menu");
                    break;
                }
                case 5:scan.nextLine();
                System.out.println("Exiting....Thanks for using");
            }
        }while(roleChoice!=5);
    }
}
