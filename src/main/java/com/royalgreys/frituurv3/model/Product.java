package com.royalgreys.frituurv3.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String product_name;
    private double price_bought;
    private double price_sold;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice_bought() {
        return price_bought;
    }

    public void setPrice_bought(double price_bought) {
        this.price_bought = price_bought;
    }

    public double getPrice_sold() {
        return price_sold;
    }

    public void setPrice_sold(double price_sold) {
        this.price_sold = price_sold;
    }
}
