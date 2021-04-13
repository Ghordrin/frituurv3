package com.royalgreys.frituurv3.repository;

import com.royalgreys.frituurv3.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface
EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByUsername(String name);


}
