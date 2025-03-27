package com.example.eshop.orders;

import com.example.eshop.basket.BasketView;
import com.example.eshop.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    UserService userService;
    @Autowired
    OrderRepository orderRepository;

    public void createOrder(List<BasketView.BasketProductView> products) {
        Order order = new Order();
        order.setUserId(userService.getLoggedInUser().getUserId());
        order.setOrderLines(
                products.stream()
                        .map(product -> new OrderLine(order.getOrderId(),
                                product.getProductId(),
                                product.getQuantity())).toList()
        );
        orderRepository.save(order);
    }
}
