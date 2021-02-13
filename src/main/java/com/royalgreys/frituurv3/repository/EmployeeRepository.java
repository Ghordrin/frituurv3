package com.royalgreys.frituurv3.repository;

import com.royalgreys.frituurv3.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface
EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("FROM Employee where username=?1")
    Employee findByUsername(String name);


}
