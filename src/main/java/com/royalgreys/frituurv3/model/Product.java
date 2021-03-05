package com.royalgreys.frituurv3.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private double priceBought;
    private double priceSold;

    @ManyToOne
    private OrderDetails orderDetails;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int product_id) {
        this.productId = product_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String product_name) {
        this.productName = product_name;
    }

    public double getPriceBought() {
        return priceBought;
    }

    public void setPriceBought(double price_bought) {
        this.priceBought = price_bought;
    }

    public double getPriceSold() {
        return priceSold;
    }

    public void setPriceSold(double price_sold) {
        this.priceSold = price_sold;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }
}
