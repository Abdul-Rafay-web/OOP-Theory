package Q2;

public class Team {
    String teamName;
    Robot robot;
    Team(String teamName, String robotName) {
        this.teamName = teamName;
        this.robot = new Robot(robotName);
    }
}
