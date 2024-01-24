package org.hillel;

public class MyClass {
    public static void main(String[] args) {

        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        orderBoard.add("Alen");
        orderBoard.add("Yoda");
        orderBoard.add("Peter");
        orderBoard.add("Marya");

        orderBoard.printOrders();

        orderBoard.deliver();

        orderBoard.deliver(4);

        orderBoard.printOrders();
    }

}
