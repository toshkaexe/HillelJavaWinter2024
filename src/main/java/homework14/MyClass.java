package homework14;

import static homework14.ArrayValueCalculator.doCalc;

public class MyClass {
    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int resultArray4x4 = doCalc(validArray);
            System.out.println("Результат розрахунку: " + resultArray4x4);
        } catch (ArraySizeException | ArrayDataException e) {
            System.err.println("Помилка: " + e.getMessage());
            e.printStackTrace();
        }

        // Array 3x3
        String[][] invalidArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        try {
            int resultArray3x3 = doCalc(invalidArray);
            System.out.println("Результат розрахунку: " + resultArray3x3);
        } catch (ArraySizeException | ArrayDataException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "abc", "12"}, // Елемент "abc" не може бути перетворений в int
                {"13", "14", "15", "16"}
        };

        try {
            int result = doCalc(invalidDataArray);
            System.out.println("Результат розрахунку: " + result);
        } catch (ArraySizeException | ArrayDataException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
