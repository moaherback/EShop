package com.example.eshop.basket;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;

public class Basket {


    private final HashMap<Integer,Integer> products;
    public Basket() {this.products = new HashMap<>();}

    public HashMap<Integer, Integer> getProducts() {
        return products;
    }



}
