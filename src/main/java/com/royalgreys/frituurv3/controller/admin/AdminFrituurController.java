/*
 * Copyright (c) 2021. Yannick D - Ghordrin
 */

package com.royalgreys.frituurv3.controller.admin;

import com.royalgreys.frituurv3.exceptions.UsernameAlreadyExistsException;
import com.royalgreys.frituurv3.model.*;
import com.royalgreys.frituurv3.repository.BurgerRepository;
import com.royalgreys.frituurv3.repository.EmployeeRepository;
import com.royalgreys.frituurv3.repository.SauceRepository;
import com.royalgreys.frituurv3.repository.SnackRepository;
import com.royalgreys.frituurv3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/admin")
    public String adminPanel() {
        return "/admin/admin";
    }


    // Employees
    @GetMapping("/admin/employees")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "/admin/employees/adminEmployees";
    }

    @GetMapping(path = {"/admin/employees/edit/", "/admin/employees/edit/{id}"})
    public String updateEmployeeById(@PathVariable("id") int id, Model model) {
        final List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        roles.add("ROLE_ADMIN");
        model.addAttribute("roleList", roles);
        model.addAttribute("employee", employeeRepository.findById(id));
        return "/admin/employees/adminEditEmployee";
    }

    @GetMapping(path = {"/admin/employees/delete/", "admin/employees/delete/{id}"})
    public String deleteEmployeeById(@PathVariable("id") int id) {
        employeeRepository.deleteById(id);
        return "redirect:/admin/employees/";
    }

    @PostMapping(path = {"/admin/employees/update/", "admin/employees/update/{id}"})
    public String updateEmployeeById(@PathVariable("id") int id, HttpServletRequest request) {
        Employee employee = employeeRepository.findById(id).get();

        employee.setUsername(request.getParameter("employeeName"));
        employee.setRole(request.getParameter("employeeRole"));
        employeeRepository.save(employee);
        return "redirect:/admin/employees/";

    }

    @GetMapping("/admin/employees/newUser")
    public String signup(Model model) {
        model.addAttribute("employee", new Employee());
        return "/login/signup";
    }

    @PostMapping("/admin/employees/newUser/createNewUser")
    public String signupUser(@RequestParam(name = "role", defaultValue = "false") boolean isAdmin, @Valid Employee employee, Model model, BindingResult result) throws UsernameAlreadyExistsException {
        if (result.hasErrors()) {
            return "/login/signup";
        } else {
            try {
                employeeService.registerNewEmployee(employee);
                if (!isAdmin) {
                    employee.setRole("ROLE_USER"); //default
                    System.out.println("Created a normal user");
                } else {
                    employee.setRole("ROLE_ADMIN");
                    System.out.println("Created an admin user");
                }
                employeeRepository.save(employee);
            } catch (UsernameAlreadyExistsException exception) {
                model.addAttribute("userNameAlreadyExists", exception.getMessage());
                return "/login/signup";
            }
        }
        return "/login/register_succes";
    }

    // snacks


    @GetMapping("/admin/snacks")
    public String getSnacks(Model model) {
        model.addAttribute("snacks", snackRepository.findAll());
        model.addAttribute("snack", new Snack());
        return "admin/snacks/adminSnacks";
    }

    @PostMapping("/admin/snacks/new/")
    public String addSnack(@Valid Snack snack, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/admin/snacks/";
        }
        snackRepository.save(snack);
        return "redirect:/admin/snacks/";
    }

    @GetMapping(path = {"/admin/snacks/edit/", "/admin/snacks/edit/{id}"})
    public String updateSnackById(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", snackRepository.findById(id));
        return "/admin/snacks/adminEditSnack";
    }

    @GetMapping(path = {"/admin/snacks/delete/", "admin/snacks/delete/{id}"})
    public String deleteSnackById(@PathVariable("id") int id) {
        snackRepository.deleteById(id);
        return "redirect:/admin/snacks/";
    }

    @PostMapping(path = {"/admin/snacks/update", "admin/snacks/update/{id}"})
    public String updateSnackById(@PathVariable("id") int id, HttpServletRequest request) {
        Snack snack = snackRepository.findById(id).get();
        snack.setProductName(request.getParameter("productName"));
        snack.setPriceSold(Double.parseDouble(request.getParameter("priceSold")));
        snack.setPriceBought(Double.parseDouble(request.getParameter("priceBought")));
        snackRepository.save(snack);
        return "redirect:/admin/snacks/";
    }

    // Burgers

    @GetMapping("/admin/burgers")
    public String getBurgers(Model model) {
        model.addAttribute("burgers", burgerRepository.findAll());
        model.addAttribute("burger", new Burger());
        return "admin/burgers/adminBurgers";
    }

    @PostMapping("/admin/burgers/new/")
    public String addBurger(@Valid Burger burger, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/admin/burgers";
        }
        burgerRepository.save(burger);
        return "redirect:/admin/burgers/";
    }

    @GetMapping(path = {"/admin/burgers/edit/", "/admin/burgers/edit/{id}"})
    public String updateBurgerById(@PathVariable("id") int id, Model model) {
        model.addAttribute("burger", burgerRepository.findById(id));
        return "/admin/burgers/adminEditBurgers";
    }

    @GetMapping(path = {"/admin/burgers/delete/", "admin/burgers/delete/{id}"})
    public String deleteBurgerById(@PathVariable("id") int id) {
        burgerRepository.deleteById(id);
        return "redirect:/admin/burgers/";
    }

    @PostMapping(path = {"/admin/burgers/update/", "admin/burgers/update/{id}"})
    public String updateBurgerByid(@PathVariable("id") int id, HttpServletRequest request) {
        Burger burger = burgerRepository.findById(id).get();
        burger.setProductName(request.getParameter("productName"));
        burger.setPriceSold(Double.parseDouble(request.getParameter("priceSold")));
        burger.setPriceBought(Double.parseDouble(request.getParameter("priceBought")));
        burgerRepository.save(burger);
        return "redirect:/admin/burgers";

    }

    // Sauce

    @GetMapping("/admin/sauces")
    public String getSauces(Model model) {
        model.addAttribute("sauces", sauceRepository.findAll());
        model.addAttribute("sauce", new Sauce());
        return "admin/sauces/adminSauces";
    }

    @PostMapping("/admin/sauces/new/")
    public String addSauce(@Valid Sauce sauce, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/admin/sauces/";
        }
        sauceRepository.save(sauce);
        return "redirect:/admin/sauces/";
    }

    @GetMapping(path = {"/admin/sauces/edit/", "/admin/sauces/edit/{id}"})
    public String updateSauceById(@PathVariable("id") int id, Model model) {
        model.addAttribute("sauce", sauceRepository.findById(id));
        return "/admin/sauces/adminEditSauces";
    }

    @GetMapping(path = {"/admin/sauces/delete/", "admin/sauces/delete/{id}"})
    public String deleteSauceById(@PathVariable("id") int id) {
        sauceRepository.deleteById(id);
        return "redirect:/admin/sauces/";
    }

    @PostMapping(path = {"/admin/sauces/update/", "admin/sauces/update/{id}"})
    public String updateSaucesById(@PathVariable("id") int id, HttpServletRequest request) {
        Sauce sauce = sauceRepository.findById(id).get();
        sauce.setProductName(request.getParameter("productName"));
        sauce.setPriceSold(Double.parseDouble(request.getParameter("priceSold")));
        sauce.setPriceBought(Double.parseDouble(request.getParameter("priceBought")));
        sauceRepository.save(sauce);
        return "redirect:/admin/sauces/";
    }


    //attributes
    @ModelAttribute(value = "newSnack")
    public Product newSnack() {
        return new Snack();
    }

    @ModelAttribute(value = "newBurger")
    public Product newBurger() {
        return new Burger();
    }

    @ModelAttribute(value = "newSauce")
    public Product newSauce() {
        return new Sauce();
    }


}
