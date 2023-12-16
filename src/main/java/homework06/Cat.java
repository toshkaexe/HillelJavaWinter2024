package homework06;

public class Cat extends Animal{
    private static int catCount = 0;

    // Конструктор класу Cat
    public Cat() {
        super(200, 0);
        catCount++;
    }

    // Статичний метод для отримання кількості котів
    public static int getCatCount() {
        return catCount;
    }
}
