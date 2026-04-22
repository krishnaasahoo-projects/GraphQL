package com.learning.graphql_playground.lec06.dto;

import lombok.Data;

@Data
public class AgeRangeFilter {

    private Integer minAge;
    private Integer maxAge;
}
