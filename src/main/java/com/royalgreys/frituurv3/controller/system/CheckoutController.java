/*
 * Copyright (c) 2021. Yannick D - Ghordrin
 */

package com.royalgreys.frituurv3.controller.system;

import com.royalgreys.frituurv3.model.Employee;
import com.royalgreys.frituurv3.model.Order;
import com.royalgreys.frituurv3.model.OrderDetail;
import com.royalgreys.frituurv3.model.Product;
import com.royalgreys.frituurv3.repository.EmployeeRepository;
import com.royalgreys.frituurv3.repository.OrderRepository;
import com.royalgreys.frituurv3.repository.ProductRepository;
import com.royalgreys.frituurv3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.*;

@Controller
public class CheckoutController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    OrderRepository orderRepository;
    @GetMapping("/checkout")
    public String getProducts(Model model, HttpSession session, Principal principal){
        session.setAttribute("employee", employeeRepository.findByUsername(principal.getName()).get());
        System.out.println("Succesfully retrieved checkout page");
        return "checkout/checkout";
    }

    @GetMapping("/newOrder")
    public String newOrder(@ModelAttribute Order order, @ModelAttribute OrderDetail orderDetail,
                            HttpSession session){
        Employee currentEmployee = (Employee) session.getAttribute("employee");
        order = orderService.createOrder();
        order.setEmployee(currentEmployee);
        order.setPaymentMethod("CASH");
        session.setAttribute("order", order);
        return "checkout/checkout";
    }

    @PostMapping("/apto")
    public String productToList (HttpServletRequest request, HttpSession session){
        orderService.createOrderRow(request, session);
        return "redirect:/checkout";
    }

    @PostMapping("/saveOrder")
    public String saveOrder(HttpSession session){
        orderService.saveOrder((Order) session.getAttribute("order"));
        return "redirect:/checkout";
    }

    @ModelAttribute("products")
    public List<Product> productList(){
       return productRepository.findAll();
    }





    
}
