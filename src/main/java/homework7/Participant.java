package homework7;

public class Participant {
    private String name;
    private double maxRunDistance;
    private double maxJumpHeight;
    private boolean active;

    public Participant(String name, double maxRunDistance, double maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.active = true;
    }

    public String getName() {
        return name;
    }
    public boolean run(double distance) {
        if (active && distance <= maxRunDistance) {
            return true;
        } else {
            return false;
        }
    }

    // Метод, який дозволяє учаснику подолати стіну
    public boolean jump(double height) {
        if (active && height <= maxJumpHeight) {
            return true;
        } else {
            return false;
        }
    }

    // Метод для виключення учасника з гонки
    public void eliminate() {
        active = false;
    }
}
