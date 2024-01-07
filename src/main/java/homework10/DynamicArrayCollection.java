package homework10;

import java.util.Arrays;

public class DynamicArrayCollection implements Collection{
    private static final int INITIAL_CAPACITY = 10;
    private String[] array;
    private int size;

    public DynamicArrayCollection() {
        array = new String[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean add(String o) {
        ensureCapacity();
        array[size++] = o;
        return true;
    }

    @Override
    public boolean add(int index, String o) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        ensureCapacity();

        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = o;
        size++;
        return true;
    }

    @Override
    public boolean delete(String o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                array[--size] = null; // Clear the last element
                return true;
            }
        }
        return false;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index];
    }

    @Override
    public boolean contain(String o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Collection collection) {
        if (size != collection.size()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (!array[i].equals(collection.get(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean clear() {
        array = new String[INITIAL_CAPACITY];
        size = 0;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }
}
