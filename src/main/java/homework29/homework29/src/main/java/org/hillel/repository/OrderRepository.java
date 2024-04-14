package org.hillel.repository;

import lombok.Getter;
import org.hillel.dto.Order;
import org.hillel.dto.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class OrderRepository {
    private int orderId;
    private int productId;
    private Map<Integer, Order> orders;

    public OrderRepository() {
        orders = new HashMap<>();
    }
    public int addOrder(List<Product> products) {
        orderId++;
        int totalCost = 0;
        for (Product p: products) {
            productId++;
            p.setId(productId);
            totalCost += p.getCost();
        }
        Order newOrder = new Order(orderId, LocalDate.now(), totalCost, products);
        orders.put(orderId, newOrder);
        return orderId;
    }
    public Collection<Order> getAllOrders() {
        return orders.values();
    }
    public Order getOrderById(int id) {
        return orders.get(id);
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }
}
