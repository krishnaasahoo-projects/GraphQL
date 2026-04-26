package com.learning.graphql_playground.lec10.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class Product {

    private UUID id = UUID.randomUUID();
    private String description;
    private Integer price;
}
