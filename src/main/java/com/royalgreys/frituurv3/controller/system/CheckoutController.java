/*
 * Copyright (c) 2021. Yannick D - Ghordrin
 */

package com.royalgreys.frituurv3.controller.system;

import com.royalgreys.frituurv3.model.*;
import com.royalgreys.frituurv3.repository.*;
import com.royalgreys.frituurv3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class CheckoutController {

    @Autowired
    SnackRepository snackRepository;

    @Autowired
    SauceRepository sauceRepository;

    @Autowired
    BurgerRepository burgerRepository;

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @GetMapping("/checkout")
    public String getProducts(HttpSession session, Principal principal) {
        session.setAttribute("employee", employeeRepository.findByUsername(principal.getName()).get());
        System.out.println("Succesfully retrieved checkout page");
        return "checkout/checkout";
    }

    @GetMapping("/newOrder")
    public String newOrder(HttpSession session) {
        Employee currentEmployee = (Employee) session.getAttribute("employee");
        Order order = orderService.createOrder(currentEmployee);
        order.setPaymentMethod("CASH");
        session.setAttribute("order", order);
        session.setAttribute("orderList", order.getOrderDetail());
        return "redirect:/checkout";
    }

    @PostMapping("/apto")
    public String productToList(HttpServletRequest request, HttpSession session) {
        Order order = (Order) session.getAttribute("order");
        OrderDetail orderDetail = orderService.createOrderRow(request, session);
        orderService.addOrderDetailToOrderDetailList(order, orderDetail);
        return "redirect:/checkout";
    }


    @PostMapping("/saveOrder")
    public String saveOrder(HttpSession session) {
        Order order = (Order) session.getAttribute("order");
        orderService.saveOrder((order));
        return "redirect:/checkout";
    }

    @GetMapping("/deleteRow/{id}")
    public String deleteRow(@PathVariable("id") int id, HttpSession session){
        Order order = (Order) session.getAttribute("order");
        orderService.removeOrderDetailFromOrder(order, id);
        return "redirect:/checkout";
    }

    @ModelAttribute("snacks")
    public List<Snack> productList() {
        return snackRepository.findAll();
    }

    @ModelAttribute("burgers")
    public List<Burger> burgerList() {
        return burgerRepository.findAll();
    }

    @ModelAttribute("sauces")
    public List<Sauce> sauceList() {
        return sauceRepository.findAll();
    }


    @ModelAttribute("orderList")
    public List<OrderDetail> getOrderList(HttpSession session) {
        List<OrderDetail> orderDetailList = (List<OrderDetail>) session.getAttribute("orderList");
        return orderDetailList;
    }

    @ModelAttribute("order")
    public Order getOrder(HttpSession session) {
        Order order;
        if (session.getAttribute("order") != null) {
            order = (Order) session.getAttribute("order");
        } else {
            order = new Order();
        }
        return order;
    }

    @ModelAttribute("orderTotal")
    public Double getOrderTotal(HttpSession session) {
        Order order;
        double total = 0;
        if (session.getAttribute("order") != null) {
            order = (Order) session.getAttribute("order");
            total += orderService.calculateTotalAmountOfOrder(order);
        } else {
            total = 0;
        }
        return total;
    }


}
