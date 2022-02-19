package com.mtb.ehcache.ex.repository;

import com.mtb.ehcache.ex.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MithileshB
 * @created 22/11/2021 - 10:42 PM
 * @project employeeex
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByName(String name);
}
