package com.mtb.springcacheex.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MithileshB
 * @created 20/11/2021 - 6:50 PM
 * @project demo
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Address {

    private String houseNo;
    private String street;
    private String city;
    private String state;
    private String pinCode;
}
