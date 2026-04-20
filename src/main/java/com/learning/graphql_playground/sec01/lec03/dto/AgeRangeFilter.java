package com.learning.graphql_playground.sec01.lec03.dto;

import lombok.Data;

@Data
public class AgeRangeFilter {

    private Integer minAge;
    private Integer maxAge;
}
