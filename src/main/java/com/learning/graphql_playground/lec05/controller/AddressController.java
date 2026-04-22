package com.learning.graphql_playground.lec05.controller;

import com.learning.graphql_playground.lec05.dto.Address;
import com.learning.graphql_playground.lec05.dto.Customer;
import graphql.schema.DataFetchingFieldSelectionSet;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class AddressController {

    @SchemaMapping
    public Mono<Address> address(Customer customer, DataFetchingFieldSelectionSet dataField){
        System.out.println("Address : " + dataField.getFields());
        return Mono.just(
                Address.create(customer.getName() + " street ", customer.getName() + " city.")
        );
    }
}
