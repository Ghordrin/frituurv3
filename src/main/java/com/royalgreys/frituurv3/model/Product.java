package com.royalgreys.frituurv3.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity(name = "product")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @NotNull(message = "De product naam mag niet leeg zijn!")
    private String productName;

    @Pattern(regexp = "^[0-9]*\\.[0-9]+$", message = "Je getal moet minstens 1 cijfer na de komma bevatten!")
    private double priceBought;

    private double priceSold;


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

}
