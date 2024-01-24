package org.hillel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void testOrderCounterIncrement() {
        Order order1 = new Order("Alice");
        Order order2 = new Order("Bob");
        Order order3 = new Order("Kim");
        Order order4 = new Order("Peter");
        Order order5 = new Order("Tim");

        assertEquals(1, order1.getOrderNumber());
        assertEquals(2, order2.getOrderNumber());
        assertEquals(3, order3.getOrderNumber());
        assertEquals(4, order4.getOrderNumber());
        assertEquals(5, order5.getOrderNumber());
    }
}



