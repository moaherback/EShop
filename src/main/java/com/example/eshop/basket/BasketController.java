package com.example.eshop.basket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BasketController {
    @Autowired
    BasketService basketService;

    @PostMapping("/basket/add")
    String addToBasket(
            @RequestParam int productId,
            @RequestParam int quantity) {
        basketService.addProduct(productId, quantity);
        return "redirect:/products";
    }
}
