package com.learning.graphql_playground.lec06.controller;

import com.learning.graphql_playground.lec06.dto.Customer;
import com.learning.graphql_playground.lec06.dto.CustomerOrderDto;
import com.learning.graphql_playground.lec06.dto.CustomerWithOrder;
import com.learning.graphql_playground.lec06.service.CustomerOrderDataFetcher;
import com.learning.graphql_playground.lec06.service.CustomerService;
import com.learning.graphql_playground.lec06.service.OrderService;
import graphql.schema.DataFetchingFieldSelectionSet;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class CustomerController {

//    private final CustomerService customerService;
//    private final OrderService orderService;
    private final CustomerOrderDataFetcher customerOrderDataFetcher;

    @SchemaMapping(
            typeName = "Query"
    )
    public Flux<CustomerWithOrder> customers(DataFetchingFieldSelectionSet selectionSet){
        return customerOrderDataFetcher.customerOrders(selectionSet);
    }

//    @SchemaMapping(
//            typeName = "Customer"
//    )
//    public Flux<CustomerOrderDto> orders(Customer customer){
//        return orderService.orderByCustomerName(customer.getName());
//    }
}
