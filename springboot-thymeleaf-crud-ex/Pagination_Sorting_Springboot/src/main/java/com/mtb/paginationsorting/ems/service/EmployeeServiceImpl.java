package com.mtb.paginationsorting.ems.service;

import com.mtb.paginationsorting.ems.model.Employee;
import com.mtb.paginationsorting.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * @author MithileshB
 * @created 05/06/2020 - 10:01 AM
 * @project springboot-thymeleaf-crud-ex
 */
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {

        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;

        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id : " + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }
}
