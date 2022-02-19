package com.mtb.ehcache.ex.resource;

import com.mtb.ehcache.ex.cache.EmployeeCache;
import com.mtb.ehcache.ex.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MithileshB
 * @created 22/11/2021 - 10:42 PM
 * @project employeeex
 */
@RestController
@RequestMapping(value = "/rest/employees")
public class EmployeeResource {

    @Autowired
    private EmployeeCache employeeCache;

    @GetMapping(value = "/{name}")
    public Employee getEmployee(@PathVariable final String name) {
        return employeeCache.getEmployee(name);
    }
}
