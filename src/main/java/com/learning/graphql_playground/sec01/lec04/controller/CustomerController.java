package com.learning.graphql_playground.sec01.lec04.controller;

import com.learning.graphql_playground.sec01.lec04.dto.Customer;
import com.learning.graphql_playground.sec01.lec04.dto.CustomerOrderDto;
import com.learning.graphql_playground.sec01.lec04.service.CustomerService;
import com.learning.graphql_playground.sec01.lec04.service.OrderService;
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

    @BatchMapping(
            typeName = "Customer"
    )
    public Flux<List<CustomerOrderDto>> ordersBatch(List<Customer> customer){
        return orderService.orderByCustomerName(
                customer.stream().map(Customer::getName).collect(Collectors.toList())
        );
    }

}
