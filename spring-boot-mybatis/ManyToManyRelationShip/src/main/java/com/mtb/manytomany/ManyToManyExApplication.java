package com.mtb.manytomany;

import com.mtb.manytomany.model.Employee;
import com.mtb.manytomany.model.Project;
import com.mtb.manytomany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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

        /***Initializing hashset using constructors--- START*****/
        Project[] projectArrayOfMithilesh={new Project("Optus"),
        new Project("Singtel"),
        new Project("Telstra"),
        new Project("TDC NET"),
        new Project("Virgin Media")};

        Set<Project> projectSetOfMithilesh=new HashSet<>(Arrays.asList(projectArrayOfMithilesh));

        Project[] projectArrayOfMayur={new Project("Optus"),
        new Project("Singtel"),
        new Project("NetCracker")};
        Set<Project> projectSetOfMayur=new HashSet<>(Arrays.asList(projectArrayOfMayur));


        Project[] projectArrayOfTarun={new Project("Optus"),
                new Project("Singtel"),
                new Project("Barclays")};
        Set<Project> projectSetOfTarun=new HashSet<>(Arrays.asList(projectArrayOfTarun));


        Project[] projectArrayOfAjay={new Project("AT&T"),
                new Project("Singtel"),
                new Project("Telstra")};
        Set<Project> projectSetOfAjay=new HashSet<>(Arrays.asList(projectArrayOfAjay));

        /***Initializing hashset using constructors--- END*****/

        /***Initializing hashset using collections--- START*****/

        Employee[] employeeArray={new Employee("Mithilesh","Bhusari",projectSetOfMithilesh),
        new Employee("Mayur","Shetye",projectSetOfMayur),
        new Employee("Tarun","Rohila",projectSetOfTarun),
        new Employee("Ajay","Sharma",projectSetOfAjay)};

        //Set Demonstration using Collections.addAll
        Set<Employee> employeeSet= Collections.<Employee>emptySet();
        Collections.addAll(employeeSet=new HashSet<Employee>(Arrays.asList(employeeArray)));

        //Set Demonstration using Collections.unmodifiable set
        Set<Employee> employeeSet1=Collections.<Employee>emptySet();
        Collections.unmodifiableSet(new HashSet<Employee>(Arrays.asList(employeeArray)));

        /***Initializing hashset with collections--- START*****/

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
