package com.learning.graphql_playground.lec05.controller;

import com.learning.graphql_playground.lec05.dto.Customer;
import com.learning.graphql_playground.lec05.service.CustomerService;
import graphql.schema.DataFetchingFieldSelectionSet;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @SchemaMapping(
            typeName = "Query"
    )
    public Flux<Customer> customers(DataFetchingFieldSelectionSet dataField)
    {
        System.out.println("Customer : " + dataField.getFields());
        return customerService.allCustomers();
    }

}
