package org.hillel.repository;

import org.hillel.order.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>();
    }

    // Метод отримання замовлення за id
    public Order getOrderById(int id) {
        // Реалізація пошуку замовлення за id
        return  null;
    }

    // Метод отримання всіх замовлень
    public List<Order> getAllOrders() {
        return this.orders;
    }

    // Метод додавання замовлення
    public void addOrder(Order order) {
        this.orders.add(order);
    }

}
