/*
 * Copyright (c) 2021. Yannick D - Ghordrin
 */

package com.royalgreys.frituurv3.controller.system;

import com.royalgreys.frituurv3.detail.CustomUserDetail;
import com.royalgreys.frituurv3.model.Employee;
import com.royalgreys.frituurv3.model.Order;
import com.royalgreys.frituurv3.model.OrderDetails;
import com.royalgreys.frituurv3.model.Product;
import com.royalgreys.frituurv3.repository.OrderRepository;
import com.royalgreys.frituurv3.repository.ProductRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.model.IModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    ProductRepository productRepository;


    @Autowired
    OrderRepository orderRepository;
    @GetMapping("/checkout")
    public String getProducts(Model model){
        model.addAttribute("products", productRepository.findAll());
        System.out.println("Succesfully retrieved checkout page");
        return "checkout/checkout";
    }

/*    @GetMapping("/newOrder")
    public String startNewOrder(HttpSession session){

        Set<Product> products = new HashSet<>();
        session.setAttribute("orderSet", products);
        Order order = new Order();
        OrderDetails orderDetails = new OrderDetails();
        order.setOrderDetails(orderDetails);
        order.setPaymentMethod("CASH");
        System.out.println(order.toString());
        orderDetails.setProductOrderSet(products);
        return "redirect:/checkout";
    }

    @GetMapping("/apto")
    public String productToList (HttpServletRequest request, HttpSession session){
        String buttonValue = request.getParameter("buttonSnack");
        Set<Product> products = (HashSet) session.getAttribute("orderSet");
        System.out.println(buttonValue);
        products.add(productRepository.findById(Integer.parseInt(buttonValue)).get());
        System.out.println(Arrays.toString(products.toArray()));
        return "redirect:/checkout";
    }*/
    
}
