package com.royalgreys.frituurv3.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "product_history")
public class ProductHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(name = "change_date")
    private LocalDateTime localDateTime;
    @Column(name="price_old")
    private float priceOld;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public float getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(float priceOld) {
        this.priceOld = priceOld;
    }
}
