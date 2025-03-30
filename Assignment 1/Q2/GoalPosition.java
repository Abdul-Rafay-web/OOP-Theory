package Q2;

public class GoalPosition {
    int x;
    int y;
    public GoalPosition(){
        this.x=0;
        this.y=0;
    }
    public GoalPosition(int x,int y){
        this.x=x;
        this.y=y;
    }
    public boolean isGoalReached(Ball ball){
if (this.x== ball.getX() && this.y== ball.getY()){
    return true;
}else{
    return false;
}
    }
}
