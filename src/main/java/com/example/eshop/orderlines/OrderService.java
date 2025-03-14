package com.example.eshop.orderlines;

import com.example.eshop.orders.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    public List<Order> getProducts() {
        return orderRepository.findAll();
    }
}
