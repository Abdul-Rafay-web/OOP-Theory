package Q1;

public class Skill {
    String skillName;
    int skillID;
    String skillDescription;
    public Skill(String skillName, int skillID, String skillDescription) {
        super();
        this.skillName = skillName;
        this.skillID = skillID;
        this.skillDescription = skillDescription;
    }
    public void showSkillDescription(){
        System.out.println("Skill Name: " + skillName);
        System.out.println("Skill ID: " + skillID);
        System.out.println("Skill Description: " + skillDescription);
    }
    public void updateSkillDescription(String skillDescription){
        this.skillDescription = skillDescription;
    }
}
