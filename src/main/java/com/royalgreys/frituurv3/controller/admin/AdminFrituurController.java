/*
 * Copyright (c) 2021. Yannick D - Ghordrin
 */

package com.royalgreys.frituurv3.controller.admin;

import com.royalgreys.frituurv3.model.Employee;
import com.royalgreys.frituurv3.model.Product;
import com.royalgreys.frituurv3.repository.EmployeeRepository;
import com.royalgreys.frituurv3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

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

    @GetMapping(path={"/admin/employees/edit/","/admin/employees/edit/{id}"})
    public String updateEmployeeById(@PathVariable("id") int id, Model model){
            model.addAttribute("employee", employeeRepository.findById(id));
            return "editEmployee";
    }


    @GetMapping(path={"/admin/products/edit/","/admin/products/edit/{id}"})
    public String updateProductById(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productRepository.findById(id));
        return "editProduct";
    }


    @GetMapping("/admin")
    public String adminPanel(){
        return "admin";
    }

}
