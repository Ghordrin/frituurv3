/*
 * Copyright (c) 2021. Yannick D - Ghordrin
 */

package com.royalgreys.frituurv3.controller.system;

import com.royalgreys.frituurv3.detail.CustomUserDetail;
import com.royalgreys.frituurv3.exceptions.UsernameAlreadyExistsException;
import com.royalgreys.frituurv3.model.Employee;
import com.royalgreys.frituurv3.repository.EmployeeRepository;
import com.royalgreys.frituurv3.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class MainController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @GetMapping("/")
    public String home(){
        return "main/home";
    }


    @GetMapping("/login")
    public String login(){
        return "/login/login";
    }

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("employee", new Employee());
        return "/login/signup";
    }

    @PostMapping("/signupUser")
    public String signupUser(@RequestParam(name = "role", defaultValue = "false")boolean isAdmin,  Employee employee) throws UsernameAlreadyExistsException {
        customUserDetailsService.registerNewEmployee(employee);
        if(!isAdmin){
            employee.setRole("ROLE_USER"); //default
            System.out.println("Created a normal user");
        }else{
            employee.setRole("ROLE_ADMIN");
            System.out.println("Created an admin user");
        }
        employeeRepository.save(employee);
        return "/login/register_succes";
    }



}
