package com.royalgreys.frituurv3.repository;

import com.royalgreys.frituurv3.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    @Query(value = "select sum(order_total) from orders where DATEDIFF(curdate(), order_time) = 0", nativeQuery = true)
    double getOrderTotalOfToday();

    @Query(value = "select count(order_id) from orders where DATEDIFF(curdate(), order_time)= 0", nativeQuery = true)
    int getAmountOfOrdersFromCurrentDay();

    @Query(value = "select max(order_total) from orders where DATEDIFF(curdate(), order_time) = 0", nativeQuery = true)
    int getHighestOrderTotal();

    @Query(value = "SELECT * from orders where DATEDIFF(curdate(), order_time) = 0", nativeQuery = true)
    List<Order> getAllOrdersFromToday();

}
