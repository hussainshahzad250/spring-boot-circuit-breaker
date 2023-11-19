package com.hussain.utils;

import com.hussain.response.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestUtils {

    @Lazy
    @Autowired
    private RestTemplate restTemplate;

    public List<OrderDTO> fetchOrders(String url) {
        return restTemplate.getForObject(url, ArrayList.class);
    }
}
