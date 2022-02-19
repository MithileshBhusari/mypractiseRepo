package com.mtb.service.userservice.vo;

import com.mtb.service.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MithileshB
 * @created 28/01/2022 - 9:42 PM
 * @project user-service
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private User user;
    private Department department;
}
