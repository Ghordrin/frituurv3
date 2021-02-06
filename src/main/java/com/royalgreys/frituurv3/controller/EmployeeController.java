package com.royalgreys.frituurv3.controller;


import com.royalgreys.frituurv3.model.Employee;
import com.royalgreys.frituurv3.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public @ResponseBody Iterable<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Employee> getEmployeeById(@PathVariable("id") int id){
        return employeeRepository.findById(id);
    }
}
