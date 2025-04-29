package com.example.eshop.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(int id) {
        return productRepository.findById((long) id).orElseThrow(
                () -> new RuntimeException("Product not found")
        );
    }

    public List<Product> getProductById(List<Integer> productIds) {
        return productRepository.findByProductIdIn(productIds);
    }

    public List<Product> getProductsByCategory(ProductCategory category) {
        return productRepository.findByProductCategory(category);
    }

    public List<Product> getProductsByName(String name) {
        return productRepository.findByProductNameContaining(name);
    }

    public Product updateProductName(int productId, String newName) {
        Product product = productRepository.findById((long) productId).orElseThrow();
        product.setProductName(newName);
        return productRepository.save(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById((long) id);
    }
}
