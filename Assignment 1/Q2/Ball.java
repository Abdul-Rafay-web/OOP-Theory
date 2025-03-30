package Q2;

public class Ball {
    private int x,y;
    public Ball(){
        this.x=0;
        this.y=0;
    }
    public Ball(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void move(int dx,int dy){
        this.x+=dx;
        this.y+=dy;
    }
    public Ball getPosition(){
        return new Ball(this.x,this.y);
    }
}
