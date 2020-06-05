package com.mtb.paginationsorting.ems.controller;

import com.mtb.paginationsorting.ems.model.Employee;
import com.mtb.paginationsorting.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author MithileshB
 * @created 05/06/2020 - 9:27 AM
 * @project springboot-thymeleaf-crud-ex
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return findPaginated(1,"firstName","asc",model);
        //  return findPaginated(1,"firstName","asc",model);
    }

    @GetMapping("showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        //create Model Attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        System.out.println("showNewEmployeeForm");
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        //get Employee from the service
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {

        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,Model model){
        int pageSize=5;

        Page<Employee> page=employeeService.findPaginated(pageNo,pageSize,sortField,sortDir);
        List<Employee>  employeeList=page.getContent();

        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());

        model.addAttribute("sortField",sortField);
        model.addAttribute("sortDir",sortDir);
        model.addAttribute("reverseSortDir",sortDir.equals("asc")?"desc":"asc");

        model.addAttribute("employeeList",employeeList);
        return "index";
    }
}
