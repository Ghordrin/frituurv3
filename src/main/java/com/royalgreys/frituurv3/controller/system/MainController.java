/*
 * Copyright (c) 2021. Yannick D - Ghordrin
 */

package com.royalgreys.frituurv3.controller.system;

import com.royalgreys.frituurv3.model.Employee;
import com.royalgreys.frituurv3.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class MainController {
    @Autowired
    EmployeeRepository employeeRepository;


    @GetMapping("/")
    public String home(){
        return "home";
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("employee", new Employee());
        return "signup";
    }

    @PostMapping("/signupUser")
    public String signupUser(Employee employee){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPass = passwordEncoder.encode(employee.getPassword());
        employee.setEnabled(1); // enabled = 1, not enabled = 0
        employee.setRole("ROLE_USER"); //default
        employee.setPassword(encodedPass);
        employeeRepository.save(employee);
        return "register_succes";
    }



}
