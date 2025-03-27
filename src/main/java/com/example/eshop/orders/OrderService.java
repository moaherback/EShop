package com.example.eshop.orders;

import com.example.eshop.basket.BasketService;
import com.example.eshop.basket.BasketView;
import com.example.eshop.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    BasketService basketService;
    @Autowired
    UserService userService;
    @Autowired
    OrderRepository orderRepository;


    public void createOrder() {
        Order order = new Order();
        BasketView basket = basketService.showBasket();
        order.setUserId(userService.getLoggedInUser().getUserId());
        order.setOrderLines(
                basket.getProducts().stream()
                        .map(product -> new OrderLine(order.getOrderId(),
                                product.getProductId(),
                                product.getQuantity(),
                                product.getProductPrice())).toList()
        );
        order.setOrderTotal(basket.getTotalPrice());
        orderRepository.save(order);
    }
}
