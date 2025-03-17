package com.example.eshop.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
   // public List<Order> getOrder() {

        //return OrderRepository.findAll();
  //  }
}
