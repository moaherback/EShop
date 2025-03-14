package com.example.eshop.orders;

import com.example.eshop.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Product, Long> {
}
