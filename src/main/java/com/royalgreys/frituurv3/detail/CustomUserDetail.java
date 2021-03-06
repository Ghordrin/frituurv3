/*
 * Copyright (c) 2021. Yannick D - Ghordrin
 */

package com.royalgreys.frituurv3.detail;

import com.royalgreys.frituurv3.model.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetail implements UserDetails {

    private final String username;
    private final String password;
    private final int enabled;
    private final int id;
    private final List<GrantedAuthority> authorityList;

    public CustomUserDetail(Employee employee) {
        this.username = employee.getUsername();
        this.password = employee.getPassword();
        this.enabled = employee.getEnabled();
        this.id = employee.getEmployee_id();
        this.authorityList = Arrays.stream(employee.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
