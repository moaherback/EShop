package com.example.eshop.orders;

import jakarta.persistence.*;


@Entity
@Table(name= "orderlines")

public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int orderLineId;

    private int orderId;

    private int productId;

    private int quantity;

    private String productName;

    private int unitPrice;

    public OrderLine(int orderId, int productId, int quantity, int unitPrice, String productName) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.productName = productName;
    }
    public OrderLine() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(int orderLineId) {
        this.orderLineId = orderLineId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
}

