package com.royalgreys.frituurv3.model;

 import javax.validation.constraints.NotNull;

import javax.persistence.*;
 import javax.validation.constraints.Size;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;

    @NotNull(message = "Gebruikersnaam mag niet NULL zijn. ")
    @Size(min=2, max = 16, message = "Gebruikersnaam moet minimum 2 en maximaal 16 karakters hebben!")
    private String username;
    @NotNull(message = "Wachtwoord mag niet NULL zijn. ")
    @Size(min = 6, max = 16,  message = "Wachtwoord moet minimaal 6 en maximaal 16 karakters hebben!")
    private String password;
    private String role;
    private int enabled;

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
