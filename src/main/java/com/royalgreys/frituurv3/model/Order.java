/*
 * Copyright (c) 2021. Yannick D - Ghordrin
 */

package com.royalgreys.frituurv3.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int order_id;
    private final LocalDateTime order_time = LocalDateTime.now();



}
