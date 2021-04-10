package com.royalgreys.frituurv3.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "burger")
public class Burger implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int burgerId;
        private String burgerName;
        private double priceBought;
        private double priceSold;

        @ManyToOne
        private OrderDetail orderDetail;

        public int getBurgerId() {
            return burgerId;
        }

        public void setBurgerId(int product_id) {
            this.burgerId = product_id;
        }

        public String getBurgerName() {
            return burgerName;
        }

        public void setBurgerName(String product_name) {
            this.burgerName = product_name;
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

        public OrderDetail getOrderDetails() {
            return orderDetail;
        }

        public void setOrderDetails(OrderDetail orderDetail) {
            this.orderDetail = orderDetail;
        }

}
