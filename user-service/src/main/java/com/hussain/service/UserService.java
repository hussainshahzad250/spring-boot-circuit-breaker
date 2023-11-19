package com.hussain.service;

import com.hussain.constants.Constant;
import com.hussain.response.Response;
import com.hussain.utils.RestUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserService implements Constant {

    private static final String ORDER_URL = "http://localhost:9191/orders";

    private final RestUtils restUtils;

    public Response getUsers(String category) {
        String url = category == null ? ORDER_URL : ORDER_URL + "/" + category;
        return new Response(SUCCESS, restUtils.fetchOrders(url), HttpStatus.OK);
    }
}
