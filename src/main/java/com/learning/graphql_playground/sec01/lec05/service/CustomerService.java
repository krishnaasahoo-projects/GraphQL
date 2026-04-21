package com.learning.graphql_playground.sec01.lec05.service;

import com.learning.graphql_playground.sec01.lec05.dto.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CustomerService {

    private final Flux<Customer> flux = Flux.just(
            Customer.create(1,"kk",23,"pune"),
            Customer.create(2,"gp",22,"blr"),
            Customer.create(3,"gk",24,"delhi")
    );

    public Flux<Customer> allCustomers(){
        return flux;
    }
}
