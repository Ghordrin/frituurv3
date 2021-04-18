package com.royalgreys.frituurv3.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employee_id;

    @Size(min = 2, max = 15, message = "Gebruikersnaam moet tussen groter dan 1 en kleiner dan 16 karakters zijn!")
    private String username;

    @Size(min = 6)
    private String password;
    private String role;
    private int enabled;

    public Employee() {
    }

    public Employee(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
