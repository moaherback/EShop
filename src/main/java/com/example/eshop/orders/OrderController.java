package com.example.eshop.orders;

import com.example.eshop.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;

    @PostMapping("/order/create")
    public String createOrder(Model model) {
        if (userService.getLoggedInUser()== null){
            return "redirect:/user/login";
        }
        model.addAttribute("order",orderService.createOrder());

        return "orderconfirmation";
    }
}

