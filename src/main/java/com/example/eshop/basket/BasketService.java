package com.example.eshop.basket;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;

@SessionScope
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service
public class BasketService {
    private Basket currentBasket = new Basket();


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

    public void decreaseProduct(int productId, int quantity) {
        int currentQuantity;
        if (currentBasket.getProducts().get(productId) == null) {
            currentQuantity = 0;
        } else {
            currentQuantity = currentBasket.getProducts().get(productId);
        }
        if (currentQuantity - quantity <= 0) {
            currentBasket.getProducts().remove(productId);
        } else {
            currentBasket.getProducts().put(productId, currentQuantity - quantity);
        }
    }

    public void clearBasket() {
        currentBasket = new Basket();
    }
}
