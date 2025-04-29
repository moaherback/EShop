package com.example.eshop.products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {
    @Autowired
    ProductService productService;

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/api/products/{id}")
    public Product getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @GetMapping("/api/products/search")
    public List<Product> getProductsSearch(@RequestParam String name) {
        return productService.getProductsByName(name);
    }

    @PutMapping("/api/products/{id}")
    public Product updateProduct(@PathVariable int id, @RequestParam String name) {
        return productService.updateProductName(id, name);
    }

    @DeleteMapping("/api/products/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }

    @PostMapping("/api/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}
