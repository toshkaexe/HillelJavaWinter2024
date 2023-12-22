package homework7;

public class Person implements Uchastnik {
    private String name;

    public Person(String name) {
        this.name = name;
    }
    @Override
    public void introduce() {

        System.out.println("Hi, I am a human. My name is " + name + ".");
    }
    @Override
    public void run() {
        System.out.println("Human is running.");
    }
    @Override
    public void jump() {
        System.out.println("Human is jumping");
    }

}
