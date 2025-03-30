package Q1;

import java.util.ArrayList;

public class Sport {
    String sportName;
    String sportDescription;
    int sportID;
    ArrayList<Skill> requiredSkills;
    public Sport(String sportName,int sportID,String sportDescription){
        this.sportName = sportName;
        this.sportID = sportID;
        this.sportDescription = sportDescription;
        this.requiredSkills = new ArrayList<>();
    }
    public void addRequiredSkill(Skill skill){
        requiredSkills.add(skill);
    }
    public void removeRequiredSkill(int id){
        for (Skill skill:requiredSkills){
            if (skill.skillID==id){
                requiredSkills.remove(skill);
            }
        }
    }
public void displaySportDetails(){
        System.out.println("Name: " + sportName);
        System.out.println("ID: " + sportID);
        System.out.println("Description: " + sportDescription);
        System.out.println("Required Skills: " + requiredSkills);
}
}
