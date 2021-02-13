/*
 * Copyright (c) 2021. Yannick D - Ghordrin
 */

package com.royalgreys.frituurv3.service;

import com.royalgreys.frituurv3.detail.CustomUserDetail;
import com.royalgreys.frituurv3.model.Employee;
import com.royalgreys.frituurv3.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(s);
        if(employee == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetail(employee);
    }
}
