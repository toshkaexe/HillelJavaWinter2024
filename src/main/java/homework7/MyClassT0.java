package homework7;

public class MyClassT0 {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Площа кола: " + circle.calculateArea());

        Triangle triangle = new Triangle(4, 7);
        System.out.println("Площа трикутника: " + triangle.calculateArea());

        Square square = new Square(6);
        System.out.println("Площа квадрата: " + square.calculateArea());

        // Створення масиву фігур
        GeometricFigure[] figures = new GeometricFigure[3];
        figures[0] = new Circle(5);
        figures[1] = new Triangle(4, 7);
        figures[2] = new Square(6);

        System.out.println("Сумарна площа всіх фігур: " + calculateTotalArea(figures));

        Uchastnik person = new Person("Bogdan");
        Uchastnik cat = new Cat("Barsik");
        Uchastnik robot = new Robot("AR-2343");

        person.introduce();
        person.run();
        person.jump();

        cat.introduce();
        cat.run();
        cat.jump();

        robot.introduce();
        robot.run();
        robot.jump();

///
        // Створення об'єктів різних типів "Учасник"
        Participant[] participants = {
                new Participant("Іван", 15, 1.5),
                new Participant("Марія", 12, 2),
                new Participant("Олег", 20, 1)
        };

        // Створення об'єктів різних типів "Перешкода"
        Obstacle[] obstacles = {
                new RunningTrack(10),
                new Wall(1.5),
                new RunningTrack(15),
                new Wall(2),
                new RunningTrack(8)
        };

        // Проходження учасниками кожної перешкоди
        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                obstacle.overcome(participant);
            }
            System.out.println(); // Додатковий рядок між учасниками
        }
    }


    private static double calculateTotalArea(GeometricFigure[] figures) {
        double totalArea = 0;
        for (GeometricFigure figure : figures) {
            totalArea += figure.calculateArea();
        }
        return totalArea;
    }

}
