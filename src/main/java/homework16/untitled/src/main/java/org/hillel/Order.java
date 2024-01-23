package org.hillel;

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
}
