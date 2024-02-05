package org.hillel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Average: " + calcucateAvarage(numbers));


        List<String> inputList = Arrays.asList("one", "two", "three");

        List<Pair> result = convertToUppercase(inputList);

        // Printing the result
        for (Pair pair : result) {
            System.out.println("{" + pair.getLowercase() + ":" + pair.getUppercase() + "}");
        }
    }


    public static double calcucateAvarage(List<Integer> array) {
        return array.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }



    public static List<Pair> convertToUppercase(List<String> strings) {
        return strings.stream()
                .map(s -> new Pair(s, s.toUpperCase()))
                .collect(Collectors.toList());
    }


}

