package com.royalgreys.frituurv3.repository;

import com.royalgreys.frituurv3.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    @Query(value = "select sum(order_total) from orders where DATEDIFF(curdate(), order_time) = 0", nativeQuery = true)
    Double getOrderTotalOfToday();

    @Query(value = "select count(order_id) from orders where DATEDIFF(curdate(), order_time)= 0", nativeQuery = true)
    Integer getAmountOfOrdersFromCurrentDay();

    @Query(value = "select max(order_total) from orders where DATEDIFF(curdate(), order_time) = 0", nativeQuery = true)
    Integer getHighestOrderTotal();

    @Query(value = "SELECT * from orders where DATEDIFF(curdate(), order_time) = 0 order by order_time desc", nativeQuery = true)
    List<Order> getAllOrdersFromToday();

    Optional<Order> getOrderByOrderId(int id);

}
