package org.hillel;

public class Order {
    private static int orderCounter = 1;
    private final int orderNumber;
    private final String customerName;

    public Order(final String customerName) {
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
