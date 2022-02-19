package com.example.springdataauditing.api.dao;

import com.example.springdataauditing.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MithileshB
 * @created 21/10/2021 - 4:19 PM
 * @project spring-data-auditing
 */
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
