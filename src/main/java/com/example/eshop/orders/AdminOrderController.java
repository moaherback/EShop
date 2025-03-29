package com.example.eshop.orders;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminOrderController {
    private final OrderService orderService;

    public AdminOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping ("/admin/orders")
    public String getOrders(Model model) {
        model.addAttribute("dispatchedorders", orderService.getDispatchedOrders());
        model.addAttribute("notdispatchedorders", orderService.getNotDispatchedOrders());
        return "orderdispatch";
    }

    @PostMapping("/admin/order/dispatch")
    public String dispatch(@RequestParam int orderId) {
        orderService.dispatchOrder(orderId);
        return "redirect:/admin/orders";
    }
}
