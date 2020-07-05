package com.mtb.manytomany.emp_project.repository;

import com.mtb.manytomany.emp_project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author MithileshB
 * @created 04/07/2020 - 7:24 PM
 * @project spring-boot-mybatis
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    Project findByTitle(String title);
}
