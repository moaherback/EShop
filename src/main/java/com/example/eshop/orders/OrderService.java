package com.example.eshop.orders;

import com.example.eshop.basket.BasketService;
import com.example.eshop.basket.BasketView;
import com.example.eshop.users.User;
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


    public Order createOrder() {
        Order order = new Order();
        BasketView basket = basketService.showBasket();
        User currentUser= userService.getLoggedInUser();
        order.setUserId(currentUser.getUserId());
        order.setUsername(currentUser.getUsername());
        order.setOrderLines(
                basket.getProducts().stream()
                        .map(product -> new OrderLine(order.getOrderId(),
                                product.getProductId(),
                                product.getQuantity(),
                                product.getProductPrice(),
                                product.getProductName())).toList()
        );
        order.setOrderTotal(basket.getTotalPrice());
        orderRepository.save(order);
        return order;
    }

    public List<Order> getDispatchedOrders() {
        return orderRepository.findByDispatched(true);
    }
    public List<Order> getNotDispatchedOrders() {
        return orderRepository.findByDispatched(false);
    }

    public void dispatchOrder(int orderId) {
        Order order = orderRepository.findById((long) orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setDispatched(true);
        orderRepository.save(order);
    }
}
