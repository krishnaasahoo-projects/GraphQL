package com.learning.graphql_playground.sec01.lec05.controller;

import com.learning.graphql_playground.sec01.lec05.dto.Account;
import com.learning.graphql_playground.sec01.lec05.dto.Customer;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Controller
public class AccountController {

    @SchemaMapping
    public Mono<Account> account(Customer customer){
        return Mono.just(Account.create(UUID.randomUUID(),500,"SAVINGS"));
    }
}
