package homework7;

public class Robot implements Uchastnik {
    private String model;

    public Robot(String model) {
        this.model = model;
    }

    @Override
    public void introduce() {
        System.out.println("Hi, I am a robot, my model is" + model + ".");
    }
    @Override
    public void run() {
        System.out.println("Robot is running");
    }
    @Override
    public void jump() {
        System.out.println("Robot is jumping");
    }
}
