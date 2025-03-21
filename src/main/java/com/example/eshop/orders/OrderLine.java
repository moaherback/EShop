package com.example.eshop.orders;

import jakarta.persistence.*;


@Entity
@Table(name= "orderlines")

public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderLineId;

    private int quantity;

    public int getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(int orderLineId) {
        this.orderLineId = orderLineId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;

    }
}
