package com.hussain.controller;

import com.hussain.entity.Order;
import com.hussain.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;


    @GetMapping
    public List<Order> getOrders() {
        log.debug("Request initiated to fetch orders");
        return orderRepository.findAll();
    }

    @GetMapping("/{category}")
    public List<Order> getOrdersByCategory(@PathVariable String category) {
        log.info("Request initiated to fetch orders for category {}", category);
        return orderRepository.findByCategory(category);
    }
}
