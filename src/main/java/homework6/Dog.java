package homework6;

class Dog extends Animal {
    public static int totalDogs = 0;
    private int maxRunDistance = 500;
    private int maxSwimDistance = 10;

    private String name;

    Dog(String name) {
        totalDogs++;
        this.name = name;
    }


    @Override
    void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println("Собака " + name + " пробігла " + distance + " м");
        } else {
            System.out.println("Собака " + name + "не може пробігти " + distance + " м");
        }
    }

    @Override
    void swim(int distance) {
        if (distance <= maxSwimDistance) {
            System.out.println("Собака " + name + " пропливла " + distance + " м");
        } else {
            System.out.println("Собака " + name + " не може проплисти " + distance + " м");
        }
    }
}