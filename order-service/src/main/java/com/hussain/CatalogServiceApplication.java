package com.hussain;

import com.hussain.entity.Order;
import com.hussain.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@AllArgsConstructor
@SpringBootApplication
public class CatalogServiceApplication {

    private final OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class, args);
        log.info("Order started successfully...");
    }

    @PostConstruct
    public void initOrdersTable() {
        List<Order> orders = Stream.of(
                        new Order("mobile", "electronics", "white", 20000),
                        new Order("T-Shirt", "clothes", "black", 999),
                        new Order("Jeans", "clothes", "blue", 1999),
                        new Order("Laptop", "electronics", "gray", 50000),
                        new Order("digital watch", "electronics", "black", 2500),
                        new Order("Fan", "electronics", "black", 50000)
                ).
                collect(Collectors.toList());
        orderRepository.saveAll(orders);
        log.info("Order saved successfully...");
    }
}
