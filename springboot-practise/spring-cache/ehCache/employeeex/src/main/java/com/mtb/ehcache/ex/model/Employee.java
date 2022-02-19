package com.mtb.ehcache.ex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author MithileshB
 * @created 22/11/2021 - 10:42 PM
 * @project employeeex
 */
@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String teamName;
    private String salary;


    public Employee(){

    }
    public Employee(String name, String teamName, String salary) {
        this.name = name;
        this.teamName = teamName;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamName='" + teamName + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
