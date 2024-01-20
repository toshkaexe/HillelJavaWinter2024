package homework15;

import java.util.Scanner;

public class myClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитування довжини послідовності
        System.out.print("Введіть довжину послідовності цифр: ");
        int length = scanner.nextInt();

        // Перевірка на валідність введення
        if (length <= 0) {
            System.out.println("Помилка: довжина повинна бути більше 0.");
            return;
        }

        // Зчитування самої послідовності
        System.out.print("Введіть послідовність цифр: ");
        String sequence = scanner.next();

        // Перевірка, чи містить введена стрічка тільки цифри
        if (!sequence.matches("\\d+")) {
            System.out.println("Помилка: послідовність має містити тільки цифри.");
            return;
        }

        // Виведення в псевдографіці
        System.out.println("Ваша послідовність в псевдографіці:");
        printPseudoGraphics(sequence);
    }

    // Метод для виведення в псевдографіці
    private static void printPseudoGraphics(String sequence) {
        for (char digit : sequence.toCharArray()) {
            switch (digit) {
                case '0':
                    System.out.print(" _ ");
                    break;
                case '1':
                    System.out.print(" | ");
                    break;
                case '2':
                    System.out.print("  _");
                    break;
                case '3':
                    System.out.print(" _|");
                    break;
                case '4':
                    System.out.print("|_|");
                    break;
                case '5':
                    System.out.print("|_ ");
                    break;
                case '6':
                    System.out.print("  |");
                    break;
                case '7':
                    System.out.print("| |");
                    break;
                case '8':
                    System.out.print("|_|");
                    break;
                case '9':
                    System.out.print("|_ ");
                    break;
                default:
                    // Якщо цифра не входить в межі 0-9, пропускаємо
                    System.out.print("   ");
                    break;
            }
        }
        System.out.println(); // Перехід на новий рядок після виведення всіх цифр
    }

}
