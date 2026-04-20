package com.learning.graphql_playground.sec01.lec02.service;

import com.learning.graphql_playground.sec01.lec02.dto.AgeRangeFilter;
import com.learning.graphql_playground.sec01.lec02.dto.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    private final Flux<Customer> flux = Flux.just(
            Customer.create(1,"kk",23,"pune"),
            Customer.create(2,"gp",22,"blr")
    );

    public Flux<Customer> allCustomers(){
        return flux;
    }

    public Mono<Customer> customerById(Integer id){
        return flux.filter(c->c.getId().equals(id)).next();
    }

    public Flux<Customer> customersNameContains(String name){
        return flux.filter(c->c.getName().contains(name));
    }

    public Flux<Customer> withinAge(Integer min, Integer max){
        return flux.filter(c->c.getAge()>= min && c.getAge()<= max);
    }

    public Flux<Customer> withinAge(AgeRangeFilter ageRangeFilter){
        return flux.filter(c->c.getAge()>= ageRangeFilter.getMinAge()
        && c.getAge()<= ageRangeFilter.getMaxAge());
    }
}
