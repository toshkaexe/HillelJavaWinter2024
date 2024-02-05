package org.hillel;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testCalculateAverage() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 6);
        // The last parameter is the delta for double comparison
        assertEquals(3.2, Main.calcucateAvarage(numbers), 0.001);
    }
    @Test
    public void testConvertToUppercase() {

        List<String> inputList = Arrays.asList("one", "two", "three");
        List<Pair> result = Main.convertToUppercase(inputList);

        assertEquals(3, result.size());

        assertEquals("one", result.get(0).getLowercase());
        assertEquals("ONE", result.get(0).getUppercase());

        assertEquals("two", result.get(1).getLowercase());
        assertEquals("TWO", result.get(1).getUppercase());

        assertEquals("three", result.get(2).getLowercase());
        assertEquals("THREE", result.get(2).getUppercase());
    }

}
