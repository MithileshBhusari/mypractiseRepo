package com.mtb.ehcache.ex.cache;

import com.mtb.ehcache.ex.model.Employee;
import com.mtb.ehcache.ex.repository.EmployeeRepository;
import com.mtb.ehcache.ex.resource.EmployeeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author MithileshB
 * @created 22/11/2021 - 10:41 PM
 * @project employeeex
 */
@Component
public class EmployeeCache {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Cacheable(value = "employeeCache", key = "#name")
    public Employee getEmployee(String name) {
        System.out.println("Retrieving from Database for Name:" + name);
        return employeeRepository.findByName(name);
    }
}
