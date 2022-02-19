package com.mtb.service.userservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MithileshB
 * @created 28/01/2022 - 9:41 PM
 * @project user-service
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
