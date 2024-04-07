package org.hillel.coffee.order;

public class Order {
    private static int orderCounter = 1;
    private int orderNumber;
    private String customerName;

    public Order(String customerName) {
        int val;
        val =4;
        Number val3= 3;
        String d="3";


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
