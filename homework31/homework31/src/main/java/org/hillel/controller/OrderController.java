package org.hillel.controller;

import org.hillel.entity.Order;
import org.hillel.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        logger.info("GET request received for order with id: {}", id);
        return orderService.getOrderById(id).orElse(null);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        logger.info("GET request received for all orders");
        return orderService.getAllOrders();
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        logger.info("POST request received to add new order");
        return orderService.addOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        logger.info("DELETE request received for order with id: {}", id);
        orderService.deleteOrder(id);
    }
}
