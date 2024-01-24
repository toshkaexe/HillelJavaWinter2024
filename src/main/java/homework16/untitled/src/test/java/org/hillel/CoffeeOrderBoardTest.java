package org.hillel;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeOrderBoardTest {

    public static CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

    @BeforeAll
    public static void setUp() {
        coffeeOrderBoard.clear();
        coffeeOrderBoard.add("Alice");
        coffeeOrderBoard.add("Bob");
        coffeeOrderBoard.add("Charlie");
        coffeeOrderBoard.add("Megan");
        coffeeOrderBoard.add("Christian");
        coffeeOrderBoard.add("Tom");

    }

    @Test
    void testAddAndDraw() {
        String expectedOutput = "=================\n" +
                "Num | Name\n" +
                "1 | Alice\n" +
                "2 | Bob\n" +
                "3 | Charlie\n" +
                "4 | Megan\n" +
                "5 | Christian\n" +
                "6 | Tom";
        assertEquals(expectedOutput, getConsoleOutput(coffeeOrderBoard::printOrders));
    }

    @Test
    void testDeliver() {


        String expectedOutput = "Delivering order: 1 | Alice";
        assertEquals(expectedOutput, getConsoleOutput(coffeeOrderBoard::deliver));

        expectedOutput = "Delivering order: 2 | Bob";
        assertEquals(expectedOutput, getConsoleOutput(coffeeOrderBoard::deliver));
    }

    @Test
    void testDeliverWithOrderNumber() {


        String expectedOutput = "Delivering order: 3 | Charlie";
        assertEquals(expectedOutput, getConsoleOutput(() -> coffeeOrderBoard.deliver(3)));
    }

    @Test
    void testDeliverWithInvalidOrderNumber() {


        String expectedOutput = "Order not found.";
        assertEquals(expectedOutput, getConsoleOutput(() -> coffeeOrderBoard.deliver(30)));
    }

    private String getConsoleOutput(Runnable runnable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            runnable.run();
            return outputStream.toString().trim();
        } finally {
            System.setOut(originalOut);
        }
    }
}
