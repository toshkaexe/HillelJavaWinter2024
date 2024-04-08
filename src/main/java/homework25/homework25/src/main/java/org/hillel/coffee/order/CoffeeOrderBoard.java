package org.hillel.coffee.order;



import java.util.ArrayList;

import java.util.List;

public class CoffeeOrderBoard {
    private List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public Order deliver() {
        if (!orders.isEmpty()) {
            Order nextOrder = orders.remove(0);
            return nextOrder;
        }
            System.out.println("No orders to deliver.");
        return null;
    }

    public Order deliver(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                orders.remove(order);
               // System.out.println("Delivering order #" + order.getOrderNumber() + " for " + order.getCustomerName());
                return order;
            }
        }
        //System.out.println("Order #" + orderNumber + " not found.");
        return  null;
    }

    public List<String> printOrders() {
        List<String> result = new ArrayList<>();
        for (Order order : orders) {
            result.add(order.getOrderNumber() + " | " + order.getCustomerName());
        }
        return result;


    }
}
