package org.hillel.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hillel.dto.Order;
import org.hillel.dto.Product;
import org.hillel.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor

public class OrderController {
    private final OrderRepository op;

    private static final String ENDPOINT = "Endpoint : %s ";

    public Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/ping")
    public String ping() {
        log.info(String.format(ENDPOINT, "GET /ping"));
        return "Welcome to the homework. It works";
    }

    @PostMapping("/add")
    public int addOrder(@RequestBody List<Product> products) {
        log.info(String.format(ENDPOINT, "POST /add"));
        return op.addOrder(products);
    }

    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable int id) {
        log.info(String.format(ENDPOINT, "GET /order/id"));
        return op.getOrderById(id);
    }

    @GetMapping("/orders")
    public Collection<Order> getAllOrders() {
        log.info(String.format(ENDPOINT, "GET /orders"));
        return op.getAllOrders();
    }
}
