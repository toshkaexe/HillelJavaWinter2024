package homework7;

public class Cat implements Uchastnik {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void introduce() {
        System.out.println("I am cat, my name " + name + ".");
    }
    @Override
    public void run() {
        System.out.println("Cat is running");
    }

    @Override
    public void jump() {
        System.out.println("Cat ir jumping");
    }

}
