package homework10;

public class MyClass {
    public static void main(String[] args) {

        DynamicArrayCollection myCollection1 = new DynamicArrayCollection();
        myCollection1.add("One");
        myCollection1.add("Two");
        myCollection1.add("Three");

        DynamicArrayCollection myCollection2 = new DynamicArrayCollection();
        myCollection2.add("One");
        myCollection2.add("Two");
        myCollection2.add("Three");

        // Выводим размер
        System.out.println("Размер коллекции: " + myCollection1.size());

        // и все элементы
        for (int i = 0; i < myCollection1.size(); i++) {
            System.out.println("Элемент " + i + ": " + myCollection1.get(i));
        }

        // проверка наличия элемента в коллекции
        System.out.println("Есть ли в коллекции значение 'Two': " + myCollection1.contain("Two"));

        boolean areEqual = myCollection1.equals(myCollection2);

        // Виводимо результат порівняння
        System.out.println("Равны ли две коллекции: " + areEqual);


        myCollection1.delete("Two");
        System.out.println("Размер коллекции после удаления " + myCollection1.size());

        myCollection1.clear();
        System.out.println("Размер коллекции после  clear(): " + myCollection1.size());
    }
}
