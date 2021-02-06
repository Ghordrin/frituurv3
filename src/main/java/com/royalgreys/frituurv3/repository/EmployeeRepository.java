package com.royalgreys.frituurv3.repository;

import com.royalgreys.frituurv3.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
