package homework7;

public class Participant {
    private String name;
    private double maxRunDistance;
    private double maxJumpHeight;
    private boolean active;
    private double runDistance;
    private double jumpHeight;

    public Participant(String name, double maxRunDistance, double maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.active = true;
        this.runDistance = 0;
        this.jumpHeight = 0;
    }


    // Метод, який дозволяє учаснику подолати бігову доріжку
    public boolean run(double distance) {
        if (active && distance <= maxRunDistance) {
            runDistance += distance;
            return true;
        } else {
            return false;
        }
    }
    // Метод, який дозволяє учаснику подолати стіну
    public boolean jump(double height) {
        if (isActive() && height <= maxJumpHeight) {
            jumpHeight += height;
            return true;
        } else {
            return false;
        }
    }

    // Метод для виключення учасника з гонки
    public void eliminate() {
        this.active = false;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }
    public double getRunDistance() {
        return runDistance;
    }

    public double getJumpHeight() {
        return jumpHeight;
    }
}

