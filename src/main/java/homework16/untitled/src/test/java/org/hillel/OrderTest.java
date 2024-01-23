package org.hillel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class OrderTest {
    @Test
    public void testOrderCreation() {
        Order order = new Order("John Doe");

        assertEquals(1, order.getOrderNumber());
        assertEquals("John Doe", order.getCustomerName());
    }

    @Test
    public void testOrderCounterIncrement() {
        Order order1 = new Order("Alice");
        Order order2 = new Order("Bob");

        assertEquals(1, order1.getOrderNumber());
        assertEquals(2, order2.getOrderNumber());
    }

    @Test
    public void testEquality() {
        Order order1 = new Order("Alice");
        Order order2 = new Order("Alice");
        Order order3 = new Order("Bob");

        assertEquals(order1, order2);
        assertNotEquals(order1, order3);
    }
}
