package com.example.springdataauditing.api.service;

import com.example.springdataauditing.api.dao.EmployeeRepository;
import com.example.springdataauditing.api.dto.InputRequest;
import com.example.springdataauditing.api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * @author MithileshB
 * @created 21/10/2021 - 4:25 PM
 * @project spring-data-auditing
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public String saveEmployee(InputRequest<Employee> request){
        String currentUser= request.getLoggedInUser();
        request.setTimezone(Calendar.getInstance().getTimeZone().getDisplayName());
        Employee employee = request.getEmployee();
        employee.setCreatedBy(currentUser);
        repository.save(employee);
        return "Employee saved successfully...!!!";
    }

    public String updateEmployee(int id,double salary,InputRequest<Employee> request){
        Employee employee=repository.findById(id).get();
        if(employee!=null){
            employee.setSalary(salary);
            employee.setModifiedBy(request.getLoggedInUser());
            repository.saveAndFlush(employee);
        }else{
            throw new RuntimeException("Employee not found with id:"+id);
        }
        return "Employee updated Successfully";
    }


}
