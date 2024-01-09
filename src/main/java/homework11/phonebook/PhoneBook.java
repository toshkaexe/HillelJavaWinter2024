package homework11.phonebook;

import homework10.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneBook {
    private List<Record> records;

    public PhoneBook() {
        this.records = new ArrayList<>();
    }

    public void add(Record record) {
        records.add(record);
    }

    public Record find(String name) {
        for (Record record : records) {
            if (record.getName().equalsIgnoreCase(name)) {
                return record; // Знайдено перший запис з вказаним ім'ям
            }
        }
        return null; // Запис не знайдено
    }

    public List<Record> findAll(String name) {
        List<Record> foundRecords = new ArrayList<>();
        for (Record record : records) {
            if (record.getName().equalsIgnoreCase(name)) {
                foundRecords.add(record);
            }
        }
        return foundRecords.isEmpty() ? Collections.emptyList() : foundRecords; //
        // Повертаємо список або пустой список, якщо нічого не знайдено
    }
}
