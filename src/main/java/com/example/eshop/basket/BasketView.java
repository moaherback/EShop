package com.example.eshop.basket;

import java.util.List;

public class BasketView {

    List<BasketProductView> products;
    int totalPrice;

    public BasketView(List<BasketProductView> products) {
        this.products = products;
        this.totalPrice = products.stream().mapToInt(BasketProductView::getTotalPrice)
                .sum();;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public List<BasketProductView> getProducts() {
        return products;
    }

    static class BasketProductView{

        int productId;
        String productName;
        int productPrice;
        int quantity;

        public BasketProductView(int productId, String productName, int productPrice, int quantity) {
            this.productId = productId;
            this.productName = productName;
            this.productPrice = productPrice;
            this.quantity = quantity;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public int getProductPrice() {
            return productPrice;
        }

        public int getQuantity() {
            return quantity;
        }

        public int getTotalPrice() {
            return productPrice * quantity;
        }
    }
}
