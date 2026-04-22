package com.learning.graphql_playground.lec02.controller;

import com.learning.graphql_playground.lec02.dto.AgeRangeFilter;
import com.learning.graphql_playground.lec02.dto.Customer;
import com.learning.graphql_playground.lec02.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @QueryMapping
    public Flux<Customer> customer(){
        return customerService.allCustomers();
    }

    @QueryMapping
    public Mono<Customer> customerById(@Argument Integer id){
        return customerService.customerById(id);
    }

    @QueryMapping
    public Flux<Customer> customersNameContains(@Argument String name){
        return customerService.customersNameContains(name);
    }

//    @QueryMapping
//    public Flux<Customer> customersByAgeRange(@Argument Integer minAge, @Argument Integer maxAge){
//        return customerService.withinAge(minAge,maxAge);
//    }

        @QueryMapping
    public Flux<Customer> customersByAgeRange(@Argument("filter") AgeRangeFilter ageRangeFilter){
        return customerService.withinAge(ageRangeFilter);
    }

}
