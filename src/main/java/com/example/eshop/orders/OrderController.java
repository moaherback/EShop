package com.example.eshop.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    public static class OrderRepository {
    }
}
