package com.learning.graphql_playground.lec16.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MultiCustomerAssignment {

    private CustomerDto a;
    private CustomerDto b;
}

