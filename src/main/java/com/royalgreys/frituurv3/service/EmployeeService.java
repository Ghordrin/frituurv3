/*
 * Copyright (c) 2021. Yannick D - Ghordrin
 */

package com.royalgreys.frituurv3.service;

import com.royalgreys.frituurv3.detail.CustomUserDetail;
import com.royalgreys.frituurv3.exceptions.UsernameAlreadyExistsException;
import com.royalgreys.frituurv3.model.Employee;
import com.royalgreys.frituurv3.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findByUsername(s);
        employee.orElseThrow(() -> new UsernameNotFoundException("No user found: {" + s + "}"));
        return employee.map(CustomUserDetail::new).get();
    }

    public Employee registerNewEmployee(Employee employee) throws UsernameAlreadyExistsException {
        if (employeeExists(employee.getUsername())) {
            throw new UsernameAlreadyExistsException("Er bestaat reeds een gebruiker met deze naam. Gebruik een andere naam aub.");
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(employee.getPassword());
            employee.setEnabled(1);
            employee.setRole("ROLE_USER");
            employee.setPassword(encodedPassword);
        }

        return employee;
    }


    private boolean employeeExists(String username) {
        return employeeRepository.findByUsername(username).isPresent();
    }
}
