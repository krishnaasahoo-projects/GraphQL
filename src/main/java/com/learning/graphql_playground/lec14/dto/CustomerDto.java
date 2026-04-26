package com.learning.graphql_playground.lec14.dto;

import lombok.Data;

@Data
//@NoArgsConstructor
//@AllArgsConstructor(staticName = "create")
public class CustomerDto {

    private Integer id;
    private String name;
    private Integer age;
    private String city;
}
