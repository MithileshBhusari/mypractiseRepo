package com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.students.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity //To make student as JPA Entity
@Table(name = "students") //To create table with name
public class Student {


    @Id //To make it primary key
    @GeneratedValue(strategy = GenerationType.AUTO) //Primary Key Generation Strategy
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Column(name="email")
    private String email;

    @Column(name = "phone_no")
    private long phoneNo;

    public Student(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
}

