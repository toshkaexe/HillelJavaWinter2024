package homework4;

public class HomeWorkApp {
    public static void main(String[] args) {

        printThreeWords();
        //Task 3
        checkSumSign();
        //Task 4
        printColor();

        //Task 5
        compareNumbers();
        // Task 6
        int number1 = -70;
        int number2 = 9;
        boolean result = isSumInRange(number1, number2);
        System.out.println("Is the sum in range? " + result);

        // Task 7
        int number = -5;
        printPositiveOrNegative(number);

        //Task 8
        number = -8;
        boolean isNegative = isNegativeNumber(number);
        System.out.println("Is the number negative? " + isNegative);

        // Task 9
        String message = "Hello, World!";
        int count = 4;
        printStringMultipleTimes(message, count);

        //Task 10
        int year = 2024;
        String yesNo = isLeapYear(year) ? " is " : " is not ";
        System.out.println(year + yesNo + "leap year");

    }

    //Task 2
    public static void printThreeWords() {

        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    //Task 3
    public static void checkSumSign() {
        int a = -300;
        int b = 34;
        if (a + b >= 0) {
            System.out.println("Сума позитивна");
        } else {
            System.out.println("Сума негативна");
        }
    }

    //Task 4
    public static void printColor() {
        int i = 0;
        if (i <= 0) {
            System.out.println("Червоний");


        } else if (i > 0 || i <= 100) {
            System.out.println("Жовтий");
        } else {
            System.out.println("Зелений");
        }
    }

    //Task 5
    public static void compareNumbers() {
        int a = 10;
        int b = 5;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    //Task 6
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    //Task 7
    public static void printPositiveOrNegative(int number) {
        if (number >= 0) {
            System.out.println("Число " + number + " є додатнім або нулем.");
        } else {
            System.out.println("Число " + number + " є від'ємним.");
        }
    }

    //Task 8
    public static boolean isNegativeNumber(int number) {
        return number < 0;
    }

    //Task 9
    public static void printStringMultipleTimes(String str, int times) {
        if (times <= 0) {
            System.out.println("times is less than or equal to zero ");
        } else {
            for (int i = 0; i < times; i++) {
                System.out.println(str);
            }
        }
    }

    //Task 10
    public static boolean isLeapYear(int year) {

        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }
}
