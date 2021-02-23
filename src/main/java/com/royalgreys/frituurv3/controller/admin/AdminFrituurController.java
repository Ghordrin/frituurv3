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
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("product", new Product());
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

    @GetMapping(path={"/admin/products/delete/","admin/products/delete/{id}"})
    public String deleteProductById(@PathVariable("id") int id){
        productRepository.deleteById(id);
        return "redirect:/admin/products/";
    }

    @GetMapping(path={"/admin/employees/delete/","admin/employees/delete/{id}"})
    public String deleteEmployeeById(@PathVariable("id") int id){
        employeeRepository.deleteById(id);
        return "redirect:/admin/employees/";
    }

    @PostMapping("/admin/products/new/")
    public String addProduct(Product product){
        productRepository.save(product);
        return "redirect:/admin/products/";
    }

    @GetMapping("/admin")
    public String adminPanel(){
        return "admin";
    }


    //attributes
    @ModelAttribute(value = "newProduct")
    public Product newProduct(){
        return new Product();
    }


}
