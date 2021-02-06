package com.royalgreys.frituurv3.controller;

import com.royalgreys.frituurv3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/checkout")
    public String getProducts(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "checkout";
    }
}
