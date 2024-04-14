package org.hillel.repository;

import org.hillel.dto.Order;
import org.hillel.dto.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class OrderRepository {
    private int orderId;
    private int productId;
    private Map<Integer, Order> orderMap;

    public OrderRepository() {
        orderMap = new HashMap<>();
    }
    public int addOrder(List<Product> products) {
        orderId++;
        int totalCosts = 0;
        for (Product p: products) {
            productId++;
            p.setId(productId);
            totalCosts += p.getCost();
        }
        Order newOrder = new Order(orderId, LocalDate.now(), totalCosts, products);
        orderMap.put(orderId, newOrder);
        return orderId;
    }
    public Collection<Order> getAllOrders() {
        return orderMap.values();
    }
    public Order getOrderById(int id) {
        return orderMap.get(id);
    }

    public Map<Integer, Order> getOrderMap() {
        return orderMap;
    }
}
