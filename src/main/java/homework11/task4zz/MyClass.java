package homework11.task4zz;

import java.util.ArrayList;
import java.util.List;

public class MyClass {
    public static void main(String[] args) {

        List<String> wordList = List.of("bird", "fox", "bird", "cat", "bird", "dog", "cat", "fox", "bird", "cat", "flamingo");
        List<WordOccurrence> occurrences = findOccurrence(wordList);

        // у консоль
        for (WordOccurrence occurrence : occurrences) {
            System.out.println("{name: \"" + occurrence.getName() + "\", occurrence: " + occurrence.getOccurrence() + "}");
        }
    }

    public static List<WordOccurrence> findOccurrence(List<String> wordList) {
        List<WordOccurrence> occurrences = new ArrayList<>();

        for (String word : wordList) {
            boolean found = false;

            // Перевіряємо, чи вже є це слово в списку occurrences
            for (WordOccurrence occurrence : occurrences) {
                if (occurrence.getName().equals(word)) {
                    occurrence.incrementOccurrence();
                    found = true;
                    break;
                }
            }

            // Якщо слово ще не знайдено, додаємо новий запис у список occurrences
            if (!found) {
                occurrences.add(new WordOccurrence(word));
            }
        }

        return occurrences;
    }

}
