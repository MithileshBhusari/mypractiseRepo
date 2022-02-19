package com.example.springdataauditing.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author MithileshB
 * @created 21/10/2021 - 3:37 PM
 * @project spring-data-auditing
 */

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "EMPLOYEE_TB")
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "MM/dd/yyyy")
    private String doj;
    private String dept;
    private double salary;

    @CreatedDate
    private String createDate;
    @LastModifiedDate
    private String lastModifiedDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String modifiedBy;


}
