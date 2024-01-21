package homework14;

import java.util.Arrays;

public class ArrayValueCalculator {
    public static int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        // Перевірка розміру масиву
        if (array.length != 4 || Arrays.stream(array).anyMatch(row -> row.length != 4)) {
            throw new ArraySizeException("Масив має некоректний розмір");
        }

        int result = 0;

        // Обробка кожного елемента масиву
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    // Перетворення рядка в int
                    int value = Integer.parseInt(array[i][j]);
                    result += value;
                } catch (NumberFormatException e) {
                    // Виняток при невдалому перетворенні
                    throw new ArrayDataException("Невірні дані у елемента [" + i + "][" + j + "]", e);
                }
            }
        }

        return result;
    }
}
