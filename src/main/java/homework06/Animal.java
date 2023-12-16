package homework06;

public class Animal {
    private int runLimit;
    private int swimLimit;
    private static int animalCount = 0;

    // Конструктор класу Animal
    public Animal(int runLimit, int swimLimit) {
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        animalCount++;
    }

    // Метод для бігу тварини
    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println("Тварина пробігла " + distance + " м");
        } else {
            System.out.println("Тварина не змогла пробігти " + distance + " м, бо вичерпала ліміт");
        }
    }

    // Метод для плавання тварини
    public void swim(int distance) {
        if (distance <= swimLimit) {
            System.out.println("Тварина пропливла " + distance + " м");
        } else {
            System.out.println("Тварина не змогла проплисти " + distance + " м, бо вичерпала ліміт");
        }
    }
    public static int getAnimalCount() {
        return animalCount;
    }
}
