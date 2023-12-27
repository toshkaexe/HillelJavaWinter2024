package homework9;

public class MyClass {
    public static void main(String[] args) {
        DynamicStringArray dynamicArray = new DynamicStringArray();
        dynamicArray.add("One");
        dynamicArray.add("Two");
        dynamicArray.add("Three");
        dynamicArray.add(1, "Four");
        System.out.println("DynamicArray content: " + dynamicArray.toString());

        System.out.println("Element at index 2: " + dynamicArray.get(2));

        dynamicArray.delete("Two");

        System.out.println("Size after deletion: " + dynamicArray.getSize());

        // Виведення змісту колекції у вигляді рядка
        System.out.println("DynamicArray content: " + dynamicArray.toString());
    }
}
