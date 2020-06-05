package com.mtb.paginationsorting.ems.repository;

import com.mtb.paginationsorting.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author MithileshB
 * @created 05/06/2020 - 9:59 AM
 * @project springboot-thymeleaf-crud-ex
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, PagingAndSortingRepository<Employee,Long> {

}
