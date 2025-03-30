package Q2;

public class Robot {
    private String robotName;
    private int noOfHits;

    public Robot(String robotName) {
        this.robotName = robotName;
        this.noOfHits = 0;
    }

    public void hitBall(Ball ball, final String direction) {
        this.noOfHits++;
        switch (direction.toLowerCase()) {
            case "up":
                ball.move(0, 1);
                break;
            case "down":
                ball.move(-1, 0);
                break;
            case "left":
                ball.move(-1, 1);
                break;
            case "right":
                ball.move(1, 0);
                break;
            default:
                System.out.println("Enter a valid direction");
        }
    }
    public int getNoofHits() {
        return this.noOfHits;
    }
    public String getRobotName() {
        return this.robotName;
    }
}
