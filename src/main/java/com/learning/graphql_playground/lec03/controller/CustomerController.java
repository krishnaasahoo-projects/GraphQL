package com.learning.graphql_playground.lec03.controller;

import com.learning.graphql_playground.lec03.dto.Customer;
import com.learning.graphql_playground.lec03.dto.CustomerOrderDto;
import com.learning.graphql_playground.lec03.service.CustomerService;
import com.learning.graphql_playground.lec03.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final OrderService orderService;

    @SchemaMapping(
            typeName = "Query"
    )
    public Flux<Customer> customers(){
        return customerService.allCustomers();
    }

    @SchemaMapping(
            typeName = "Customer"
    )
    public Flux<CustomerOrderDto> orders(Customer customer, @Argument Integer limit){
        return orderService.orderByCustomerName(customer.getName()).take(limit);
    }
}
