/*
 * Copyright (c) 2021. Yannick D - Ghordrin
 */

package com.royalgreys.frituurv3.controller.admin;

import com.royalgreys.frituurv3.repository.EmployeeRepository;
import com.royalgreys.frituurv3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AdminFrituurController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/admin/products")
    public String getFrituur(Model model){
        model.addAttribute("products", productRepository.findAll() );
        return "adminProducts";
    }

    @GetMapping("/admin/employees")
    public String getEmployees(Model model){
        model.addAttribute("employees", employeeRepository.findAll() );
        return "adminEmployees";
    }
}
