package com.royalgreys.frituurv3.service;

import com.royalgreys.frituurv3.model.Employee;
import com.royalgreys.frituurv3.model.Order;
import com.royalgreys.frituurv3.model.OrderDetail;
import com.royalgreys.frituurv3.model.Product;
import com.royalgreys.frituurv3.repository.*;
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
    private SnackRepository snackRepository;

    @Autowired
    private BurgerRepository burgerRepository;

    @Autowired
    private SauceRepository sauceRepository;


    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public Order createOrder(Employee employee) {
        Order order = new Order();
        order.setEmployee(employee);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        order.setOrderDetail(orderDetailList);
        return order;
    }

    public Product getButtonIdFromServletRequest(HttpServletRequest request) {
        String buttonValue = request.getParameter("buttonSnack");
        String typeOfSnack = request.getParameter("snackType");
        Product product;

        switch (typeOfSnack) {
            case "snack":
                product = snackRepository.findById(Integer.parseInt(buttonValue)).get();
                break;
            case "burger":
                product = burgerRepository.findById(Integer.parseInt(buttonValue)).get();
                break;
            case "sauce":
                product = sauceRepository.findById(Integer.parseInt(buttonValue)).get();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + typeOfSnack);
        }
        return product;
    }

    public OrderDetail createOrderRow(HttpServletRequest request, HttpSession session) {
        OrderDetail orderDetail = new OrderDetail();
        Order order = (Order) session.getAttribute("order");
        Product product = getButtonIdFromServletRequest(request);
        orderDetail.setProduct(product);
        orderDetail.setQuantity(1);
        orderDetail.setOrder(order);
        return orderDetail;
    }


    public void addOrderDetailToOrderDetailList(Order order, OrderDetail orderDetail) {
        order.getOrderDetail().add(orderDetail);
    }

    public void removeOrderDetailFromOrder(Order order, int id) {
        order.getOrderDetail().remove(id);
    }

    public void setOrderPaymentMethod(Order order, String paymentMethod) {
        order.setPaymentMethod(paymentMethod);
    }

    public void saveOrderDetailRow(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }


    public void saveOrder(Order order) {
        for (int i = 0; i < order.getOrderDetail().size(); i++) {
            saveOrderDetailRow(order.getOrderDetail().get(1));
        }
        orderRepository.save(order);
    }

    public double calculateTotalAmountOfOrder(Order order) {
        double total = 0;
        for (int i = 0; i < order.getOrderDetail().size(); i++) {
            total += order.getOrderDetail().get(i).getProduct().getPriceSold();
        }
        return total;
    }

}
