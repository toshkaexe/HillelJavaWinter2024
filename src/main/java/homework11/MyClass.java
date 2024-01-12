package homework11;

import java.util.ArrayList;
import java.util.List;

public class MyClass {

    public static void main(String[] args) {

        //Task 1
        List<String> wordList = List.of(
                "apple", "orange","banana",
                "apple", "apple", "apple", "apple",
                "apple", "apple", "apple", "grape",
                "grape", "grape", "grape", "banana",
                "kiwi");

        String targetWord = "apple";

        int occurrenceCount = countOccurrence(wordList, targetWord);
        System.out.println("Occurrences of '" + targetWord + "': " + occurrenceCount);

        //Task 2
        Integer[] intArray = {1, 2, 3, 4, 5};
        List<Integer> intList = toList(intArray);

        System.out.println("Array: " + java.util.Arrays.toString(intArray));
        System.out.println("List: " + intList);

        //Task 3
        List<Integer> inputList = List.of(1, 2, 3, 3, 4, 5, 5, 6, 7, 8, 8, 9);
        List<Integer> result = findUnique(inputList);
        System.out.println(result);


        //Task 4
        List<String> wordsList = List.of("bird", "fox", "bird", "cat", "bird", "dog", "cat", "fox", "bird", "cat", "flamingo");
        calcOccurrence(wordsList);

    }

    //Task 1
    public static int countOccurrence(List<String> strlist, String str) {
        int count = 0;

        for (String word : strlist) {
            if (word.equals(str)) {
                count++;
            }
        }

        return count;
    }

    //Task 2
    public static <T> List<T> toList(T[] array) {
        List<T> list = new ArrayList<>();

        for (T element : array) {
            list.add(element);
        }

        return list;
    }

    //Task 3
    public static List<Integer> findUnique(List<Integer> numberList) {
        List<Integer> uniqueList = new ArrayList<>();

        for (Integer number : numberList) {
            if (!uniqueList.contains(number)) {
                uniqueList.add(number);
            }
        }

        return uniqueList;
    }

    //Task 4
    public static void calcOccurrence(List<String> wordList) {

        int[] occurrences = new int[wordList.size()];


        for (int i = 0; i < wordList.size(); i++) {
            // Пропускаємо обробку слова, якщо вже врахували його раніше
            if (occurrences[i] != -1) {
                int count = 1;

                // Порівнюємо з рештою елементів, щоб знайти входження і збільшити кількість
                for (int j = i + 1; j < wordList.size(); j++) {
                    if (wordList.get(i).equals(wordList.get(j))) {
                        count++;
                        occurrences[j] = -1; // Відмічаємо інші входження, щоб їх не обробляти
                    }
                }

                // Виводимо результат у консоль
                System.out.println(wordList.get(i) + ": " + count);
            }
        }
    }

}
