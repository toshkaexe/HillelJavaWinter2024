package homework9;

import java.util.Arrays;

public class DynamicStringArray implements StringMethods {
    private static final int INITIAL_CAPACITY = 100;
    private String[] array;
    private int size;

    public DynamicStringArray() {
        array = new String[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean add(int index, String value) {
        if (index < 0 || index > size) {
            return false;
        }

        ensureCapacity();
        // Зсуваємо елементи для звільнення місця для нового значення
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
        return true;
    }
    @Override
    public boolean add(String value) {
        ensureCapacity();
        array[size++] = value;
        return true;
    }
    @Override
    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        // Зсуваємо елементи для видалення вказаного індексу
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null; // Зменшуємо розмір і звільнюємо останній елемент
        return true;
    }
    @Override
    public boolean delete(String value) {
        for (int i = 0; i < size; i++) {
            if (array[i] != null && array[i].equals(value)) {
                return delete(i);
            }
        }
        return false;
    }
    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return array[index];
    }

    private void ensureCapacity() {
        if (size == array.length) {
            // Подвоюємо розмір масиву, якщо він заповнений
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    public int getSize() {
        return size;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
