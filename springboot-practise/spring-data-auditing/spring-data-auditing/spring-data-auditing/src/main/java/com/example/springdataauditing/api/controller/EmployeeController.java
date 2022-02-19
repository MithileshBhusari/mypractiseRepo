package com.example.springdataauditing.api.controller;

import com.example.springdataauditing.api.dto.InputRequest;
import com.example.springdataauditing.api.model.Employee;
import com.example.springdataauditing.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author MithileshB
 * @created 21/10/2021 - 4:33 PM
 * @project spring-data-auditing
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/addEmployee")
    public String saveEmployee(@RequestBody InputRequest<Employee> request){
        return service.saveEmployee(request);
    }

    @PutMapping("/updateEmployee/{id}/{salary}")
    public String updateEmployeeSalary(@PathVariable int id,@PathVariable double salary, @RequestBody InputRequest<Employee>request){
    return  service.updateEmployee(id,salary,request);
    }
}
