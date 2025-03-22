package com.example.eshop.basket;

import java.util.HashMap;

public class Basket {


    private final HashMap<String,Integer> products;
    public Basket() {this.products = new HashMap<>();}

    public HashMap<String, Integer> getProducts() {
        return products;
    }

}
