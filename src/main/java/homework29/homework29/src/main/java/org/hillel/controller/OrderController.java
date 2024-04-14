package org.hillel.controller;

import lombok.RequiredArgsConstructor;
import org.hillel.dto.Order;
import org.hillel.dto.Product;
import org.hillel.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/")
@RequiredArgsConstructor

public class OrderController {

    private final OrderRepository orderRepository;

    private static final String INFO_ABOUT_ENDPOINT = "Endpoint : %s ";

    public Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/ping")
    public String ping() {
        log.info(String.format(INFO_ABOUT_ENDPOINT, "GET /ping"));
        return "Welcome to the homework. It works";
    }

    @PostMapping("/add")
    public int addOrder(@RequestBody List<Product> products) {
        log.info(String.format(INFO_ABOUT_ENDPOINT, "POST /add"));
        return orderRepository.addOrder(products);
    }

    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable int id) {
        log.info(String.format(INFO_ABOUT_ENDPOINT, "GET /order/id"));
        return orderRepository.getOrderById(id);
    }

    @GetMapping("/orders")
    public Collection<Order> getAllOrders() {
        log.info(String.format(INFO_ABOUT_ENDPOINT, "GET /orders"));
        return orderRepository.getAllOrders();
    }
}
