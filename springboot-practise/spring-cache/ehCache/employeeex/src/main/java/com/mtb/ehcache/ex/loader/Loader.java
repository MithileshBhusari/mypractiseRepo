package com.mtb.ehcache.ex.loader;

import com.mtb.ehcache.ex.model.Employee;
import com.mtb.ehcache.ex.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MithileshB
 * @created 22/11/2021 - 10:42 PM
 * @project employeeex
 */

@Component
public class Loader {

    @Autowired
    private EmployeeRepository employeeRepository;


    @PostConstruct
    public void load() {
        List<Employee> employeeList = getList();
        employeeRepository.saveAll(employeeList);
    }

    private List<Employee> getList() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Mithilesh", "Leo", "123L"));
        employeeList.add(new Employee("Priya", "DB", "345L"));
        return employeeList;
    }


}
