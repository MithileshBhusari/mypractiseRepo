package com.mtb.manytomany.repository;

import com.mtb.manytomany.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author MithileshB
 * @created 04/07/2020 - 7:23 PM
 * @project spring-boot-mybatis
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}