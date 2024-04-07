package org.hillel.coffee.order;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderBoard {
    private List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public void deliver() {
        if (!orders.isEmpty()) {
            Order nextOrder = orders.remove(0);
            System.out.println("Delivering order #" + nextOrder.getOrderNumber() + " for " + nextOrder.getCustomerName());
        } else {
            System.out.println("No orders to deliver.");
        }
    }

    public void deliver(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                orders.remove(order);
                System.out.println("Delivering order #" + order.getOrderNumber() + " for " + order.getCustomerName());
                return;
            }
        }
        System.out.println("Order #" + orderNumber + " not found.");
    }

    public void printOrders() {

        for (Order order : orders) {
            System.out.println(order.getOrderNumber() + " | " + order.getCustomerName());
        }

    }
}
