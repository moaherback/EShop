package com.example.eshop.basket;

import com.example.eshop.products.Product;
import com.example.eshop.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@SessionScope
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service

public class BasketService {
    @Autowired
    private ProductService productService;

    private Basket currentBasket = new Basket();

    public BasketView showBasket() {
        List<Integer> productIds = new ArrayList<>(currentBasket.getProducts().keySet());
        List<Product> products = productService.getProductById(productIds);
        return new BasketView(
                products
                        .stream()
                        .map(product -> new BasketView.BasketProductView(
                                product.getProductId(),
                                product.getProductName(),
                                product.getProductPrice(),
                                currentBasket.getProducts().get(product.getProductId())))
                        .collect(Collectors.toList()));
    }

    public void addProduct(int productId, int quantity) {
        int currentQuantity;
        if (currentBasket.getProducts().get(productId) == null) {
            currentQuantity = 0;
        } else {
            currentQuantity = currentBasket.getProducts().get(productId);
        }
        currentBasket.getProducts().put(productId, quantity + currentQuantity);
    }

    public void removeProduct(int productId) {
        currentBasket.getProducts().remove(productId);
    }

    public void clearBasket() {
        currentBasket = new Basket();
    }

    public void updateBasket(int productId, int quantity) {
        if (quantity == 0) {
            currentBasket.getProducts().remove(productId);
        }else {
            currentBasket.getProducts().put(productId, quantity);
        }
    }
}
