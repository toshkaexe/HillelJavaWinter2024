package homework6;

class Cat extends Animal {
    public static int totalCats = 0;
    private int maxRunDistance = 200;
    private String name;


    Cat(String name) {
        totalCats++;
        this.name = name;

    }

    @Override
    void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println("Кіт " + name + " пробіг " + distance + " м");
        } else {
            System.out.println("Кіт " + name + " не може пробігти " + distance + " м");
        }
    }

    @Override
    void swim(int distance) {
        System.out.println("Кіт " + name + " не вміє плавати");
    }
}