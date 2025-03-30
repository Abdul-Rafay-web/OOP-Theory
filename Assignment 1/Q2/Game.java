package Q2;

import java.util.Scanner;

public class Game {
    Robot robot1;
    Robot robot2;
    Ball ball;
    GoalPosition goal;
    public Game(Robot robot1, Robot robot2, Ball ball, int x,int y){
        this.robot1 = robot1;
        this.robot2 = robot2;
        this.ball = ball;
        this.goal = new GoalPosition(x,y);
    }
    public void startGame(){
        System.out.println("For team 1:");
        playGame(robot1);
resetBall();
System.out.println("For team 2:");
playGame(robot2);
declareWinner();
    }
    public void playGame(Robot robot1){
        Scanner scan=new Scanner(System.in);
        while (!goal.isGoalReached(this.ball)){
        System.out.println("Move the ball.Current Direction ("+this.ball.getX()+","+this.ball.getY()+")");
      String direction = scan.nextLine();
      robot1.hitBall(this.ball,direction);
    }

        System.out.println("Goal!!!!!!!!!!!!");
}
    public void declareWinner(){
        int team1Hits=this.robot1.getNoofHits();
        int team2Hits=this.robot2.getNoofHits();
        System.out.println(robot1.getRobotName()+" Hits: "+team1Hits);
        System.out.println( robot2.getRobotName()+" Hits: "+team2Hits);
        if(team1Hits>team2Hits){
            System.out.println(robot2.getRobotName()+" Wins!");
        } else if (team2Hits>team1Hits) {
            System.out.println(robot1.getRobotName()+"Wins! ");
        }else{
            System.out.println("It's a tie!");
        }
    }
    public void resetBall(){
        this.ball = new Ball();
    }
}