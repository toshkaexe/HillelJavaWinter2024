package org.hillel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class CoffeeOrderBoard {
    private List<Order> orders = new ArrayList<>();

    public void add(String customerName) {
        orders.add(new Order(customerName));
    }

    public void clear(){
        orders.clear();
    }

    public void  deliver() {
        if (!orders.isEmpty()) {
            Order nextOrder = orders.remove(0);
            System.out.println("Delivering order: " + nextOrder.getOrderNumber() + " | " + nextOrder.getCustomerName());
        } else {
            System.out.println("No orders to deliver.");
        }
    }



    public void  deliver(int orderNumber) {
        Order orderToDeliver = null;

        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                orderToDeliver = order;
                break;
            }
        }

        if (orderToDeliver != null) {
            orders.remove(orderToDeliver);
            System.out.println("Delivering order: " + orderToDeliver.getOrderNumber() + " | " + orderToDeliver.getCustomerName());
        } else {
            System.out.println("Order not found.");
        }

    }

    public void printOrders() {
        System.out.println("=================");
        System.out.println("Num | Name");

        for (Order order : orders) {
            System.out.println(order.getOrderNumber() + " | " + order.getCustomerName());
        }

    }


}
