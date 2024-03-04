package org.springframework;

import java.util.*;

public class OrderRepository {
    private final Map<Integer, Order> orderMap;

    public OrderRepository() {
        this.orderMap = new HashMap<>();
    }
    // Method to get an order by ID
    public Order getOrderById(int id) {

        return orderMap.getOrDefault(id, null);
    }

    // Method to get all orders
    public List<Order> getAllOrders() {
        return new ArrayList<>(orderMap.values());
    }

    // Method to add a new order
    public Order addOrder(Order order) {
     int id = order.getId();
        order.setId(id);
        orderMap.put(id, order);
        return order;
    }
}
