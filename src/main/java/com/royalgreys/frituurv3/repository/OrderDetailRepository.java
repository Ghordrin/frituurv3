package com.royalgreys.frituurv3.repository;

import com.royalgreys.frituurv3.model.Order;
import com.royalgreys.frituurv3.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Order> {

}
