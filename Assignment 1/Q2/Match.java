package Q2;

import java.util.Scanner;

public class Match {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter Name of the Team 1 Name");
        String nameTeam1=scan.nextLine();
        System.out.println("Enter Name of the Team 1 Robot Name");
        String nameRobot1=scan.nextLine();
        System.out.println("Enter Name of the Team 2 Name");
        String nameTeam2=scan.nextLine();
        System.out.println("Enter Name of the Team 2 Robot Name");
        String nameRobot2=scan.nextLine();
        Team team1 = new Team(nameTeam1,nameRobot1);
        Team team2 = new Team(nameTeam2,nameRobot2);
        System.out.println("Set the X and Y co-ordinates of the Goal");
        int x=scan.nextInt();
        int y=scan.nextInt();
        scan.nextLine();
        GoalPosition goalPosition = new GoalPosition(x,y);
        Ball ball=new Ball();
        Game game=new Game(team1.robot,team2.robot,ball,x,y);
game.startGame();
    }
}