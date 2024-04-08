package org.hillel.coffee.order;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyClass {
    private static final Logger logInfo = LoggerFactory.getLogger("logger.info");
    public static void main(String[] args) {

        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        orderBoard.add(new Order("Alen"));
        orderBoard.add(new Order("Yoda"));
        orderBoard.add(new Order("Obi-van"));
        orderBoard.add(new Order("John Snow"));

        logInfo.info("Curren line of orders: {}", orderBoard.printOrders());
        Order ord1 = orderBoard.deliver();
        logInfo.info("Order from the line is delivered: {}", ord1.toString());
        Order order4 = orderBoard.deliver(4);
        logInfo.info("Special Case: Order 4 is delivered: {}", order4.toString());
        orderBoard.printOrders();
        logInfo.info("Curren line of orders: {}", orderBoard.printOrders());
    }

}
