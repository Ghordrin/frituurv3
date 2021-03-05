package com.royalgreys.frituurv3.repository;

import com.royalgreys.frituurv3.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
