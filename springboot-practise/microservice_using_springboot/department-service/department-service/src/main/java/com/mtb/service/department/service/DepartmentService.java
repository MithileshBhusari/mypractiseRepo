package com.mtb.service.department.service;

import com.mtb.service.department.entity.Department;
import com.mtb.service.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MithileshB
 * @created 28/01/2022 - 8:04 PM
 * @project department-service
 */
@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
