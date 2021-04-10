package com.royalgreys.frituurv3.service;

import com.royalgreys.frituurv3.model.Employee;
import com.royalgreys.frituurv3.model.Order;
import com.royalgreys.frituurv3.model.OrderDetail;
import com.royalgreys.frituurv3.model.Product;
import com.royalgreys.frituurv3.repository.OrderDetailRepository;
import com.royalgreys.frituurv3.repository.OrderRepository;
import com.royalgreys.frituurv3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public Order createOrder(){
        Order order = new Order();
        List<OrderDetail> orderDetailList = new ArrayList<>();
        order.setOrderDetail(orderDetailList);
        return order;
    }

    public OrderDetail createOrderRow(HttpServletRequest request, HttpSession session){
        OrderDetail orderDetail = new OrderDetail();
        Order order = (Order) session.getAttribute("order");
        String buttonValue = request.getParameter("buttonSnack");
        Product product = productRepository.findById(Integer.parseInt(buttonValue)).get();
        orderDetail.setProduct(product);
        orderDetail.setQuantity(1);
        orderDetail.setOrder(order);
        session.setAttribute("orderDetails", order.getOrderDetail().add(orderDetail));
        return orderDetail;

    }

    public void setOrderPaymentMethod(Order order, String paymentMethod){
        order.setPaymentMethod(paymentMethod);
    }

    public void saveOrderDetailRow(OrderDetail orderDetail){
        orderDetailRepository.save(orderDetail);
    }

    public void saveOrder(Order order){
        orderRepository.save(order);
    }

}
