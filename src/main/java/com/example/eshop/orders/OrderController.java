package com.example.eshop.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/order/create")
    public String createOrder(Model model) {
        model.addAttribute("order",orderService.createOrder());

        return "orderconfirmation";
    }
}

