package homework6;

class Animal {
     static int totalAnimals = 0;
     private String name;

    Animal() {
        totalAnimals++;
        this.name = name;
    }

    void run(int distance) {
        System.out.println("Тварина "+ name + " пробігла " + distance + " м");
    }

    void swim(int distance) {
        System.out.println("Тварина "+ name + " пропливла " + distance + " м");
    }
}