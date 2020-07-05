package com.mtb.manytomany;

import com.mtb.manytomany.model.Employee;
import com.mtb.manytomany.model.Project;
import com.mtb.manytomany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author MithileshB
 * @created 04/07/2020 - 8:16 PM
 * @project spring-boot-mybatis
 */
@SpringBootApplication
@EnableJpaAuditing
public class ManyToManyExApplication implements CommandLineRunner {
    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(ManyToManyExApplication.class, args);
    }
    @Override
    public void run(String...args) throws Exception {

        // Create an employee
        Employee employee = new Employee();
        employee.setFirstName("Mithilesh");
        employee.setLastName("Bhusari");

        // Create project1
        Project project = new Project();
        project.setTitle("TDC NET");

        // Create project2
        Project project1 = new Project();
        project1.setTitle("Telstra");

        // employee can work on two projects,  Add project references in the employee
        employee.getProjects().add(project);
        employee.getProjects().add(project1);

        // Add employee reference in the projects
        project.getEmployees().add(employee);
        project1.getEmployees().add(employee);

        employeeRepository.save(employee);
    }
}
