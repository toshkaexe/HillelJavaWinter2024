package homework3;


import java.util.Scanner;

/*
1. За допомогою циклу for вивести на екран непарні числа від 1 до 99.
2. Дано число n за допомогою циклу for порахувати факторіал n!
3. Перепишіть програми 1 та 2 за допомогою циклу while.
4. Перепишіть програми 1 та 2 із використанням циклу do - while.
5. Дано змінні x і n обчислити x^n.
6. Вивести 10 перших чисел послідовності 0, -5,-10,-15.
7. Необхідно вивести на екран таблицю множення на Х: (будь-яке число, що вводиться з консолі)
8. Створіть масив, що містить 10 перших непарних чисел. Виведіть елементи масиву на консоль в один рядок, розділяючи комою.
9.Даний масив розмірності N, знайти найменший елемент масиву і вивести на консоль
10. У масиві із завдання 9. Визначити найбільший елемент.
11. Поміняти максимальний і найменший елементи масиву місцями. Приклад: дано масив {4, -5, 0, 6, 8}. Після заміни виглядатиме {4, 8, 0, 6, -5}.

 */
public class MyClass {
    public static void main(String[] args) {
        MyClass my = new MyClass();

        System.out.println("-Task 1-");
        my.forPrintFrom1to99();

        System.out.println("-Task 2-");
        int n = 5;
        my.factorialWithForLoop(n);
        System.out.println(String.format("Value of %d! is %d", n, my.factorialWithForLoop(n)));

        System.out.println("-Task 3-");
        my.whileDoPrintFrom1to99();
        my.factorialWithWhileLoop(n);
        System.out.println(String.format("Value of %d! is %d", n, my.factorialWithWhileLoop(n)));

        System.out.println("-Task 4-");

        my.factorialWithDoWhileLoop(n);
        System.out.println(String.format("Value of %d! is %d", n, my.factorialWithDoWhileLoop(n)));

        System.out.println("-Task 5-");
        double x = 2;
        n = -2;
        System.out.println(String.format("x= %f, n = %d, then x^n = %f", x, n, my.powerX(x, n)));
        n=3;
        System.out.println(String.format("x= %f, n = %d, then x^n = %f", x, n, my.powerX(x, n)));

        System.out.println("-Task 6-");
        my.posledovatelnost5();

        System.out.println("-Task 7-");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число для таблиці множення: ");
        // Зчитуємо введене число з консолі
        int number = scanner.nextInt();
        // Виводимо заголовок таблиці
        System.out.println("Таблиця множення для " + number + ":");
        my.productTableX_1_10(number);


        System.out.println("-Task 8-");
        my.oddArrayFirst10digits();


        System.out.println("-Task 9-");
        int[] array = {23, 56, -1, 12, 7, 45, 100, 89, 34, 18, 5, 67, 90};
        System.out.println(String.format("Min element in the array is: %d", my.findMinElement(array)));

        System.out.println("-Task 10-");
        System.out.println(String.format("Max element in the array is: %d", my.findMAXElement(array)));

        System.out.println("-Task 11-");
        System.out.println("Array before");
        my.printArray(array);
        System.out.println("Array after swap");
        my.swapMaxAndMinValueInArray(array);
    }


    //Task 1
    public void forPrintFrom1to99() {
        for (int i = 1; i <= 99; i = i + 2) {
            System.out.print (i+" ");
        }
        System.out.println();
    }

    //Task 2
    public int factorialWithForLoop(int n) {

        // Ініціалізуємо факторіал як 1, оскільки 0! і 1! рівні 1
        int factorial = 1;

        // Обчислюємо факторіал за допомогою циклу for
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    //Task 3
    // Перепишіть програми 1 та 2 за допомогою циклу while
    public void whileDoPrintFrom1to99() {
        int j = 1;
        while (j < 100) {

            System.out.print(j + " ");
            j = j + 2;
        }
        System.out.println("");
    }


    // Task 4
    // Перепишіть програми 1 та 2 із використанням циклу do - while.
    public void doWhilePrintFrom1to99() {
        int k = 1;
        do {
            System.out.print(k + " ");
            k = k + 2;
        }
        while (k < 100);
        System.out.println(" ");
    }

    public int factorialWithWhileLoop(int n) {

        // Ініціалізуємо факторіал як 1, оскільки 0! і 1! рівні 1
        int factorial = 1;
        int i = 1;


        while (i <= n){

            factorial *= i;
            i++;

        };

        return factorial;
    }

    public int factorialWithDoWhileLoop(int n) {

        // Ініціалізуємо факторіал як 1, оскільки 0! і 1! рівні 1
        int factorial = 1;
        int i = 1;

        do {
            factorial *= i;
            i++;
        }
        while (i <= n);

        return factorial;
    }

    //Task 5
    public double powerX(double x, int power) {

        double res = 1;

        if (power == 0) {
            return 1;
        }

        if (power > 0) {
            for (int i = 0; i < power; i++) {
                res = res * x;

            }
            return res;

        } else {
            for (int i = power; i < 0; i++) {
                res = res * x;
            }
            return 1 / res;
        }
    }

    // Task 6
    // Вивести 10 перших чисел послідовності 0, -5,-10,-15.
    public void posledovatelnost5() {
        int firstElement = 0;
        int difference = -5;

        for (int i = 0; i <10; i ++) {
            firstElement +=difference;
            System.out.print(firstElement + " ");
        }
        System.out.println(" ");
    }

    public void productTableX_1_10(int x) {

        for (int i = 1; i <= 10; i++) {
            double product = i * x;
            System.out.println(String.format("%d * %d = %.0f", i, x, product));
        }
    }

    // Task 8
    //Створіть масив, що містить 10 перших непарних чисел.
    // Виведіть елементи масиву на консоль в один рядок, розділяючи комою.
    public void oddArrayFirst10digits() {
        int[] oddNumbers = new int[10];

        for (int i = 0, num = 1; i < oddNumbers.length; i++, num = num + 2) {
            oddNumbers[i] = num;
        }

        for (int i = 0; i < oddNumbers.length - 1; i++) {
            System.out.print(oddNumbers[i] + ", ");
        }
        System.out.println(oddNumbers[oddNumbers.length - 1]);

    }

    //Task 9
    //Даний масив розмірності N, знайти найменший елемент масиву і вивести на консоль
    public int findMinElement(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {

            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    //Task 10
    //У масиві із завдання 9. Визначити найбільший елемент.
    public int findMAXElement(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {

            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    //Task 11
    //Поміняти максимальний і найменший елементи масиву місцями.
    // Приклад: дано масив {4, -5, 0, 6, 8}. Після заміни виглядатиме {4, 8, 0, 6, -5}.
    public void swapMaxAndMinValueInArray(int[] array) {
        int max = array[0];
        int min = array[0];
        int indexOfmin = 0;
        int indexOfmax = 0;
        for (int i = 0; i < array.length; i++) {

            if (array[i] > max) {
                max = array[i];
                indexOfmax = i;
            }
            if (array[i] < min) {
                min = array[i];
                indexOfmin = i;
            }
        }
        // меняет местами минимальный и максимальный элементы
        int temp = array[indexOfmax];
        array[indexOfmax] = array[indexOfmin];
        array[indexOfmin] = temp;


        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1]);
    }


    public void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i]);

            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("");
    }
}

