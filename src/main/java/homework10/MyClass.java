package homework10;


//Реалізувати просту динамічну колекцію для String на основі масиву.
//
//Реалізувати такі методи для роботи з колекцією:
//
//        1. boolean add(int index, String value);
//2. boolean add(String value);
//3. boolean delete(int index);
//4. boolean delete(String value);
//5. String get(int index);

public class MyClass {
    public static void main(String[] args) {

        DynamicArrayCollection myCollection = new DynamicArrayCollection();
        myCollection.add("One");
        myCollection.add("Two");
        myCollection.add("Three");

        // Выводим размер
        System.out.println("Розмір колекції: " + myCollection.size());

        //
        for (int i = 0; i < myCollection.size(); i++) {
            System.out.println("Елемент " + i + ": " + myCollection.get(i));
        }

        // Перевіряємо наявність елемента
        System.out.println("Чи містить 'Two': " + myCollection.contain("Two"));

        // Видаляємо елемент
        myCollection.delete("Two");

        // Перевіряємо розмір після видалення
        System.out.println("Розмір колекції після видалення: " + myCollection.size());

        // Очищаємо колекцію
        myCollection.clear();

        // Перевіряємо розмір після очищення
        System.out.println("Розмір колекції після очищення: " + myCollection.size());
    }
}
