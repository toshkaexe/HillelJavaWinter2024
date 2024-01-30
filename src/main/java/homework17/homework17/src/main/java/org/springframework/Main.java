package org.springframework;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Average: " + calcucateAvarage(numbers));
    }


    public static double calcucateAvarage(List<Integer> array) {
        return array.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }


    List<String> strings = Arrays.asList("one", "two", "three");


}

