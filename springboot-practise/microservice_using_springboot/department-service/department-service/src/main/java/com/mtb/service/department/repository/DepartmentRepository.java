package com.mtb.service.department.repository;

import com.mtb.service.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author MithileshB
 * @created 28/01/2022 - 8:03 PM
 * @project department-service
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department findByDepartmentId(Long     departmentId);
}
