/*
 * Copyright (c) 2021. Yannick D - Ghordrin
 */

package com.royalgreys.frituurv3.controller.admin;

import com.royalgreys.frituurv3.model.Burger;
import com.royalgreys.frituurv3.model.Product;
import com.royalgreys.frituurv3.model.Sauce;
import com.royalgreys.frituurv3.model.Snack;
import com.royalgreys.frituurv3.repository.BurgerRepository;
import com.royalgreys.frituurv3.repository.EmployeeRepository;
import com.royalgreys.frituurv3.repository.SauceRepository;
import com.royalgreys.frituurv3.repository.SnackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class AdminFrituurController {
    @Autowired
    SnackRepository snackRepository;

    @Autowired
    BurgerRepository burgerRepository;

    @Autowired
    SauceRepository sauceRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    @GetMapping("/admin")
    public String adminPanel(){
        return "/admin/admin";
    }

    // Employees
    @GetMapping("/admin/employees")
    public String getEmployees(Model model){
        model.addAttribute("employees", employeeRepository.findAll() );
        return "/admin/employees/adminEmployees";
    }

    @GetMapping(path={"/admin/employees/edit/","/admin/employees/edit/{id}"})
    public String updateEmployeeById(@PathVariable("id") int id, Model model){
            model.addAttribute("employee", employeeRepository.findById(id));
            return "/admin/employees/adminEditEmployee";
    }

    @GetMapping(path={"/admin/employees/delete/","admin/employees/delete/{id}"})
    public String deleteEmployeeById(@PathVariable("id") int id){
        employeeRepository.deleteById(id);
        return "redirect:/admin/employees/";
    }

    // snacks


    @GetMapping("/admin/snacks")
    public String getSnacks(Model model){
        model.addAttribute("snacks", snackRepository.findAll() );
        model.addAttribute("snack", new Snack());
        return "admin/snacks/adminSnacks";
    }

    @PostMapping("/admin/snacks/new/")
    public String addSnack(Snack snack){
        snackRepository.save(snack);
        return "redirect:/admin/snacks/";
    }

    @GetMapping(path={"/admin/snacks/edit/","/admin/snacks/edit/{id}"})
    public String updateSnackById(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", snackRepository.findById(id));
        return "/admin/snacks/adminEditSnack";
    }

    @GetMapping(path={"/admin/snacks/delete/","admin/snacks/delete/{id}"})
    public String deleteSnackById(@PathVariable("id") int id){
        snackRepository.deleteById(id);
        return "redirect:/admin/snacks/";
    }

    // Burgers

    @GetMapping("/admin/burgers")
    public String getBurgers(Model model){
        model.addAttribute("burgers", burgerRepository.findAll() );
        model.addAttribute("burger", new Burger());
        return "admin/burgers/adminBurgers";
    }

    @PostMapping("/admin/burgers/new/")
    public String addBurger(Burger burger){
        burgerRepository.save(burger);
        return "redirect:/admin/burgers/";
    }

    @GetMapping(path={"/admin/burgers/edit/","/admin/burgers/edit/{id}"})
    public String updateBurgerById(@PathVariable("id") int id, Model model) {
        model.addAttribute("burger", burgerRepository.findById(id));
        return "/admin/burgers/adminEditBurgers";
    }

    @GetMapping(path={"/admin/burgers/delete/","admin/burgers/delete/{id}"})
    public String deleteBurgerById(@PathVariable("id") int id){
        burgerRepository.deleteById(id);
        return "redirect:/admin/burgers/";
    }




    //attributes
    @ModelAttribute(value = "newSnack")
    public Product newSnack(){
        return new Snack();
    }

    @ModelAttribute(value = "newBurger")
    public Product newBurger(){
        return new Burger();
    }

    @ModelAttribute(value = "newSauce")
    public Product newSauce() {
        return new Sauce();
    }


}
