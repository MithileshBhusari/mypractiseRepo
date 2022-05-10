package com.example.completablefutureex.controller;

import com.example.completablefutureex.entity.Employee;
import com.example.completablefutureex.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployees")
    private List<Employee> addAllEmployees(@RequestBody List<Employee> employees){
        return employeeService.addAllEmployees(employees);
    }

    @PostMapping("/addAllEmployeesWithRunAsync")
    private Void addAllEmployeesWithRunAsync(@RequestBody List<Employee> employees) throws ExecutionException, InterruptedException {
        return employeeService.addAllEmployeesWithRunAsync(employees);
    }


    @GetMapping("/getEmployeesWithCustomExec")
    private List<Employee> getEmployeesWithSupplyAsyncAndCustomExecutor() throws ExecutionException, InterruptedException {
            return employeeService.getEmployeesWithSupplyAsyncAndCustomExecutor();
    }

    @GetMapping("/getEmployeesWithSupplyAsync")
    private List<Employee> getEmployeesWithSupplyAsync() throws ExecutionException, InterruptedException {
        return employeeService.getEmployeesWithSupplyAsync();
    }

    @GetMapping("/getEmployees")
    private List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping("/sendTrainingReminder")
    private void sendReminder(){
        employeeService.sendReminder();
    }



}
