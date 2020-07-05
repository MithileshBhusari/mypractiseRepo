package com.mtb.manytomany.emp_project;

import com.mtb.manytomany.emp_project.model.Employee;
import com.mtb.manytomany.emp_project.model.Project;
import com.mtb.manytomany.emp_project.repository.EmployeeRepository;
import com.mtb.manytomany.emp_project.repository.ProjectRepository;
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

    @Autowired
    private ProjectRepository projectRepository;

    public static void main(String[] args) {
        SpringApplication.run(ManyToManyExApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        /***Initializing hashset using constructors--- START*****/
        //Project[] projectArray={
        Project optus = new Project("Optus");
        Project singtel = new Project("Singtel");
        Project telstra = new Project("Telstra");
        Project tdcnet = new Project("TDC NET");
        Project vm = new Project("Virgin Media");
        Project nc = new Project("NetCracker");
        Project barclays = new Project("Barclays");
        Project att = new Project("AT&T");

        /***Initializing hashset using constructors--- END*****/


        /***Initializing hashset using collections--- START*****/

        Employee[] employeeArray = {new Employee("Mithilesh", "Bhusari", new HashSet<>(Arrays.asList(singtel, optus, telstra, tdcnet))),
                new Employee("Mayur", "Shetye", new HashSet<>(Arrays.asList(singtel, optus, nc))),
                new Employee("Tarun", "Rohila", new HashSet<>(Arrays.asList(singtel, optus, barclays))),
                new Employee("Ajay", "Sharma", new HashSet<>(Arrays.asList(singtel, telstra, att)))};

        //Set Demonstration using Collections.addAll
        Set<Employee> employeeSet = Collections.<Employee>emptySet();
        Collections.addAll(employeeSet = new HashSet<Employee>(Arrays.asList(employeeArray)));

        //Set Demonstration using Collections.unmodifiable set
        Set<Employee> employeeSet1 = Collections.<Employee>emptySet();
        Collections.unmodifiableSet(new HashSet<Employee>(Arrays.asList(employeeArray)));

        /***Initializing hashset with collections--- START*****/

        employeeRepository.saveAll(employeeSet);
    }
}
