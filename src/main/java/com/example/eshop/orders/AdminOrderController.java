package com.example.eshop.orders;

import com.example.eshop.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminOrderController {
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;

    public AdminOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping ("/admin/orders")
    public String getOrders(Model model) {
        if (userService.getLoggedInUser()== null || userService.getLoggedInUser().getRole()!=1){
            return "redirect:/admin/login";
        }
        model.addAttribute("dispatchedorders", orderService.getDispatchedOrders());
        model.addAttribute("notdispatchedorders", orderService.getNotDispatchedOrders());
        return "orderdispatch";
    }

    @PostMapping("/admin/order/dispatch")
    public String dispatch(@RequestParam int orderId) {
        if (userService.getLoggedInUser()== null || userService.getLoggedInUser().getRole()!=1){
            return "redirect:/admin/login";
        }
        orderService.dispatchOrder(orderId);
        return "redirect:/admin/orders";
    }
}
