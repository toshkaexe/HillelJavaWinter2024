package org.hillel.coffee.order;

public class Order {
    private static int orderCounter = 1;
    private int orderNumber;
    private String customerName;

    public Order(String customerName) {
        this.orderNumber = orderCounter++;
        this.customerName = customerName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
