package homework3;

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
/*
        System.out.println("-Task 1-");
        my.forPrintFrom1to99();

        System.out.println("-Task 2-");
        int n = 4;
        my.factorial(n);
        System.out.println(String.format("Factorial of %d is %d", n, my.factorial(n)));

        System.out.println("-Task 3-");
        my.whileDoPrintFrom1to99();

        System.out.println("-Task 4-");
        my.doWhilePrintFrom1to99();
*/
        double x = 2;
        int n = -2;
        System.out.println(my.poverx(x, n));
    }


    //Task 1
    public void forPrintFrom1to99() {
        for (int i = 1; i <= 99; i = i + 2) {
            System.out.println(i);
        }
    }

    //Task 2
    public int factorial(int n) {

        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    //Task 3
    // Перепишіть програми 1 та 2 за допомогою циклу while
    public void whileDoPrintFrom1to99() {
        int j = 1;
        while (j < 100) {

            System.out.println(j);
            j = j + 2;
        }
    }

    // Task 4
    // Перепишіть програми 1 та 2 із використанням циклу do - while.
    public void doWhilePrintFrom1to99() {
        int k = 1;
        do {
            System.out.println(k);
            k = k + 2;
        }
        while (k < 100);
    }

    //Task 5
    public double poverx(double x, int power) {

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
}
