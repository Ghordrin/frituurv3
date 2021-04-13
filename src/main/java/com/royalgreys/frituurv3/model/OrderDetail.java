/*
 * Copyright (c) 2021. Yannick D - Ghordrin
 */


package com.royalgreys.frituurv3.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.StringJoiner;

@Entity(name = "orderDetails")
public class OrderDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailId;

    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;

    @OneToOne
    private Product product;
    private int quantity;


    public OrderDetail() {
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderDetail.class.getSimpleName() + "[", "]")
                .add("orderDetailId=" + orderDetailId)
                .add("order=" + order)
                .add("product=" + product)
                .add("quantity=" + quantity)
                .toString();
    }
}
