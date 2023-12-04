package homework2;

import java.util.Scanner;

/*
2. Програма, яка знаходить середнє арифметичне значення довільної кількості чисел.
 */
public class AverageN {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть числа для обчислення середнього " +
                "(введіть 0, щоб завершити введення):");

        double sum = 0;
        int count = 0;

        while (true) {
            double number = scanner.nextDouble();

            if (number == 0) {
                break;
            }

            sum += number;
            count++;
        }

        if (count > 0) {
            double average = sum / count;
            System.out.println("Середнє арифметичне: " + average);
        } else {
            System.out.println("Не введено жодного числа.");
        }

        scanner.close();
    }


}
