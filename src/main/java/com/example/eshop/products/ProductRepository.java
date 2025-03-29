package com.example.eshop.products;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductIdIn(List<Integer> productIds);
    List<Product> findByProductCategory(ProductCategory productCategory);
    List<Product> findByProductNameContaining(String productName);
}
