package com.hillel.java;

import com.hillel.java.ContentException;
public class MyClass {
    public static void main(String[] args) {
        String inputSequence = args[0];
        // Перевірка на наявність букв
        try {
            // Перевірка на наявність букв
            if (!containsLetters(inputSequence)) {
                throw new ContentException("Помилка: Послідовність має містити тільки цифри!");
            } else{
                printPseudoGraphicsInOneRow(inputSequence);
            }
        } catch (ContentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Метод для перевірки наявності букв в стрічці
    private static boolean containsLetters(String sequence) {
        return sequence.matches("\\d+");
    }

    private static void printPseudoGraphicsInOneRow(String sequence) {
        // Рядок для зберігання псевдографіки в строці
        String[] pseudoGraphicsArray = new String[7];
        for (int i = 0; i < pseudoGraphicsArray.length; ++i) {
            pseudoGraphicsArray[i] = "";
        }

        for (char digit : sequence.toCharArray()) {
            switch (digit) {
                case '0':
                    pseudoGraphicsArray[0] += "  @@@@@@   ";
                    pseudoGraphicsArray[1] += "  @     @  ";
                    pseudoGraphicsArray[2] += "  @     @  ";
                    pseudoGraphicsArray[3] += "  @     @  ";
                    pseudoGraphicsArray[4] += "  @     @  ";
                    pseudoGraphicsArray[5] += "  @     @  ";
                    pseudoGraphicsArray[6] += "  @@@@@@   ";
                    break;
                case '1':
                    pseudoGraphicsArray[0] += "  @@@@    ";
                    pseudoGraphicsArray[1] += "     @    ";
                    pseudoGraphicsArray[2] += "     @    ";
                    pseudoGraphicsArray[3] += "     @    ";
                    pseudoGraphicsArray[4] += "     @    ";
                    pseudoGraphicsArray[5] += "     @    ";
                    pseudoGraphicsArray[6] += "  @@@@@@@ ";
                    break;
                case '2':
                    pseudoGraphicsArray[0] += "  @@@@@@  ";
                    pseudoGraphicsArray[1] += " @     @  ";
                    pseudoGraphicsArray[2] += "       @  ";
                    pseudoGraphicsArray[3] += "    @@@@  ";
                    pseudoGraphicsArray[4] += "   @      ";
                    pseudoGraphicsArray[5] += "  @       ";
                    pseudoGraphicsArray[6] += " @@@@@@   ";
                    break;
                case '3':
                    pseudoGraphicsArray[0] += "  @@@@@@  ";
                    pseudoGraphicsArray[1] += " @     @  ";
                    pseudoGraphicsArray[2] += "       @  ";
                    pseudoGraphicsArray[3] += "    @@@@  ";
                    pseudoGraphicsArray[4] += "       @  ";
                    pseudoGraphicsArray[5] += " @     @  ";
                    pseudoGraphicsArray[6] += "  @@@@@@  ";
                    break;
                case '4':
                    pseudoGraphicsArray[0] += "    @   @ ";
                    pseudoGraphicsArray[1] += "   @    @ ";
                    pseudoGraphicsArray[2] += "  @     @ ";
                    pseudoGraphicsArray[3] += " @      @ ";
                    pseudoGraphicsArray[4] += "  @@@@@@@ ";
                    pseudoGraphicsArray[5] += "       @  ";
                    pseudoGraphicsArray[6] += "       @  ";
                    break;
                case '5':
                    pseudoGraphicsArray[0] += " @@@@@@   ";
                    pseudoGraphicsArray[1] += " @        ";
                    pseudoGraphicsArray[2] += " @        ";
                    pseudoGraphicsArray[3] += " @@@@@    ";
                    pseudoGraphicsArray[4] += "      @   ";
                    pseudoGraphicsArray[5] += " @    @   ";
                    pseudoGraphicsArray[6] += "  @@@@    ";
                    break;
                case '6':
                    pseudoGraphicsArray[0] += "   @@@@@  ";
                    pseudoGraphicsArray[1] += "  @       ";
                    pseudoGraphicsArray[2] += " @        ";
                    pseudoGraphicsArray[3] += " @@@@@@   ";
                    pseudoGraphicsArray[4] += " @     @  ";
                    pseudoGraphicsArray[5] += "  @     @ ";
                    pseudoGraphicsArray[6] += "   @@@@@  ";
                    break;
                case '7':
                    pseudoGraphicsArray[0] += " @@@@@@   ";
                    pseudoGraphicsArray[1] += "      @   ";
                    pseudoGraphicsArray[2] += "     @    ";
                    pseudoGraphicsArray[3] += "    @     ";
                    pseudoGraphicsArray[4] += "   @      ";
                    pseudoGraphicsArray[5] += "  @       ";
                    pseudoGraphicsArray[6] += " @        ";
                    break;
                case '8':
                    pseudoGraphicsArray[0] += "   @@@@@   ";
                    pseudoGraphicsArray[1] += "  @     @  ";
                    pseudoGraphicsArray[2] += "  @        ";
                    pseudoGraphicsArray[3] += "  @@@@@@   ";
                    pseudoGraphicsArray[4] += " @     @   ";
                    pseudoGraphicsArray[5] += "  @     @  ";
                    pseudoGraphicsArray[6] += "   @@@@@   ";
                    break;
                case '9':
                    pseudoGraphicsArray[0] += "   @@@@@   ";
                    pseudoGraphicsArray[1] += "  @     @  ";
                    pseudoGraphicsArray[2] += " @         ";
                    pseudoGraphicsArray[3] += "  @@@@@@   ";
                    pseudoGraphicsArray[4] += "       @   ";
                    pseudoGraphicsArray[5] += " @     @   ";
                    pseudoGraphicsArray[6] += "   @@@@    ";
                    break;
                default:
                    System.out.println("Непідтримувана цифра: " + digit);
                    break;
            }
        }

        // Виводимо рядок псевдографіки в строці
        for (String row : pseudoGraphicsArray) {
            System.out.println(row);
        }
    }
}
