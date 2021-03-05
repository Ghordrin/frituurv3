/*
 * Copyright (c) 2021. Yannick D - Ghordrin
 */


package com.royalgreys.frituurv3.model;

 import javax.persistence.*;
 import java.util.HashSet;
 import java.util.Set;

@Entity(name="orderDetails")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailId;

    @OneToOne
    private Order order;


    @OneToMany
    private Set<Product> productOrderSet = new HashSet<>();

    private int quantity;


    public OrderDetails() {
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

    public Set<Product> getProductOrderSet() {
        return productOrderSet;
    }

    public void setProductOrderSet(Set<Product> productOrderSet) {
        this.productOrderSet = productOrderSet;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
