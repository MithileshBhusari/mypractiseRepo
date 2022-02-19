package com.example.springdataauditing.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author MithileshB
 * @created 21/10/2021 - 4:20 PM
 * @project spring-data-auditing
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputRequest<T> {

    @JsonProperty(value = "userId",required = true)
    private String loggedInUser;
    private String timezone;

    private T Employee;
}
