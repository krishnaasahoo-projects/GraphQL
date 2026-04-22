package com.learning.graphql_playground.lec06.service;

import com.learning.graphql_playground.lec06.dto.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Service
public class CustomerService {

    private final Flux<Customer> flux = Flux.just(
            Customer.create(1,"kk",23,"pune"),
            Customer.create(2,"gp",22,"blr"),
            Customer.create(3,"gk",24,"delhi")
    );

    public Flux<Customer> allCustomers(){
        return flux.doOnNext(c-> print("customers for " + c.getName()));
    }

    private void print(String name){
        System.out.println(LocalDateTime.now() + name);
    }
}
