package homework11.phonebook;

import java.util.List;

public class MyClass {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Додавання записів
        Record record1 = new Record("John Doe", "+123456789");
        Record record2 = new Record("Jane Doe", "+987654321");
        Record record3 = new Record("John Doe", "+111111111");

        phoneBook.add(record1);
        phoneBook.add(record2);
        phoneBook.add(record3);

        // Пошук запису за іменем
        String name = "John Doe";
        Record findName = phoneBook.find(name);

        if (findName != null) {
            System.out.println("Знайдено запис для " + name + ": " + findName.getPhoneNumber());
        } else {
            System.out.println("Запис для " + name + " не знайдено.");
        }

        // Пошук всіх записів за іменем
        List<Record> recordslist = phoneBook.findAll(name);

        if (recordslist != null) {
            System.out.println("Знайдено всі записи для " +name + ":");
            for (Record rec : recordslist) {
                System.out.println("Телефон: " + rec.getPhoneNumber());
            }
        } else {
            System.out.println("Записів для " + name + " не знайдено.");
        }
    }
}
