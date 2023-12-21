package homework6;

public class MyClass {

    public static void main(String[] args) {

        Dog bobik = new Dog("Бобик");
        Dog sharik = new Dog("Шарик");

        Cat barsik = new Cat("Барсик");
        Cat kuzya = new Cat("Кузя");

        sharik.run(300);
        sharik.swim(12);

        bobik.run(150);
        bobik.swim(5);

        barsik.run(250);
        barsik.swim(2);
        kuzya.run(100);
        kuzya.swim(100);

        System.out.println("Загальна кількість тварин: " + Animal.totalAnimals);
        System.out.println("Кількість собак: " + Dog.totalDogs);
        System.out.println("Кількість котів: " + Cat.totalCats);

    }
}

