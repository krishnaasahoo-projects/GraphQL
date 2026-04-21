package com.learning.graphql_playground.sec01.lec05.controller;

import com.learning.graphql_playground.sec01.lec05.dto.Customer;
import com.learning.graphql_playground.sec01.lec05.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @SchemaMapping(
            typeName = "Query"
    )
    public Flux<Customer> customers(){
        return customerService.allCustomers();
    }

}
