package com.mtb.manytomany.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author MithileshB
 * @created 04/07/2020 - 7:10 PM
 * @project spring-boot-mybatis
 */
@Entity
@Table(name = "mtm_projects")
public class Project extends AuditModel {

    private static final long serialVersionUID=1L;

    @Id
    @Column(name = "project_id")
    @GeneratedValue
    private long projectId;

    @Column(name = "title",unique = true)
    private String title;

    @ManyToMany(mappedBy = "projects",cascade = {CascadeType.ALL})
    private Set<Employee> employees=new HashSet<Employee>();

    public Project(){
        super();
    }

    public Project(String title){
        this.title=title;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
