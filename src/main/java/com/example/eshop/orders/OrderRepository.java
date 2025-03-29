package com.example.eshop.orders;

import com.example.eshop.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByDispatched(boolean dispatched);
}
