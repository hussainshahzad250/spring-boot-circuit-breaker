package com.hussain.controller;

import com.hussain.constants.Constant;
import com.hussain.response.Response;
import com.hussain.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class UserController implements Constant {

    private final UserService userService;

    @GetMapping("/orders")
    @CircuitBreaker(name = USER_SERVICE, fallbackMethod = "getAllAvailableProducts")
    @Retry(name = USER_SERVICE, fallbackMethod = "getAllAvailableProducts")
    public Response displayOrders(@RequestParam(name = "category", required = false) String category) {
        return userService.getUsers(category);
    }

    public Response getAllAvailableProducts(Exception e) {
        log.info("order service is not available , returning mock results");
//        List<OrderDTO> orders = Stream.of(
//                new OrderDTO(119, "LED TV", "electronics", "white", 45000),
//                new OrderDTO(345, "Headset", "electronics", "black", 7000),
//                new OrderDTO(475, "Sound bar", "electronics", "black", 13000),
//                new OrderDTO(574, "Puma Shoes", "foot wear", "black & white", 4600),
//                new OrderDTO(678, "Vegetable chopper", "kitchen", "blue", 999),
//                new OrderDTO(532, "Oven Gloves", "kitchen", "gray", 745)
//        ).collect(Collectors.toList());
//        return new Response(SUCCESS,orders, HttpStatus.OK);
        return new Response(UNAVAILABLE, HttpStatus.OK);
    }

}
