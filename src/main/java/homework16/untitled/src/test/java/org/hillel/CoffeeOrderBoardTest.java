package org.hillel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeOrderBoardTest {
    private CoffeeOrderBoard coffeeOrderBoard;

    @BeforeEach
    public void setUp() {
        coffeeOrderBoard = new CoffeeOrderBoard();
    }

    @Test
    public void testAddAndPrintOrders() {
        Order order1 = new Order("Alen");
        Order order2 = new Order("Yoda");

        coffeeOrderBoard.add(order1);
        coffeeOrderBoard.add(order2);

        String expectedOutput = "Order 1 for Alen\nOrder 2 for Yoda\n";
        assertEquals(expectedOutput, coffeeOrderBoard.printOrders());
    }

    @Test
    public void testDeliver() {
        Order order3 = new Order("Max");
        Order order4 = new Order("Lukas");

        coffeeOrderBoard.add(order3);
        coffeeOrderBoard.add(order4);

        coffeeOrderBoard.deliver();

        String expectedOutput = "Order 2 for Lukas\n";
        assertEquals(expectedOutput, coffeeOrderBoard.printOrders());
    }


    @Test
    public void testDeliverByNumber() {
        Order order5 = new Order("Anna");
        Order order6 = new Order("Pavel");

        coffeeOrderBoard.add(order5);
        coffeeOrderBoard.add(order6);

        coffeeOrderBoard.deliver(3);

        String expectedOutput =
                "Order 4 for Pavel\n";
        assertEquals(expectedOutput, coffeeOrderBoard.printOrders());
    }

}
