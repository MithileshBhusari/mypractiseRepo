package com.mtb.springcacheex.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MithileshB
 * @created 20/11/2021 - 6:49 PM
 * @project demo
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Student {

    private String studentId;
    private String firstName;
    private String lastName;
    private String age;
    private Address address;
    private String major;
}
