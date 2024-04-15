package org.hillel.coffee.order;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyClass {
    private static final Logger logger = LoggerFactory.getLogger(MyClass.class);
    public static void main(String[] args) {

        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        orderBoard.add(new Order("Alen"));
        orderBoard.add(new Order("Yoda"));
        orderBoard.add(new Order("Obi-van"));
        orderBoard.add(new Order("John Snow"));

        logger.info("Current line of orders: {}", orderBoard.printOrders());

        Order firsrOrder = orderBoard.deliver();
        logger.info("First order from the line is delivered: {}", firsrOrder.toString());

        Order order4 = orderBoard.deliver(4);
        logger.info("Special Case: Order 4 is delivered: {}", order4.toString());

        orderBoard.printOrders();
        logger.info("Current line of orders: {}", orderBoard.printOrders());
    }

}
