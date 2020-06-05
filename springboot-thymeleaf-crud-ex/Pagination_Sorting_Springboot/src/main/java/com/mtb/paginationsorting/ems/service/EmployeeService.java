package com.mtb.paginationsorting.ems.service;

import com.mtb.paginationsorting.ems.model.Employee;

import java.util.List;

/**
 * @author MithileshB
 * @created 05/06/2020 - 10:00 AM
 * @project springboot-thymeleaf-crud-ex
 */


public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(long id);

    void deleteEmployeeById(long id);

}
