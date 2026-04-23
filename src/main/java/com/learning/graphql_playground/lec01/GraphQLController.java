package com.learning.graphql_playground.lec01;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.concurrent.ThreadLocalRandom;

/**
 *  Introduction to Graphql with Schema.graphqls mapping
 *
 */
@Controller
public class GraphQLController {

    @QueryMapping("sayHello")
    public Mono<String> sayHelloController(){
        return Mono.just("Hello World");
    }

    @QueryMapping("sayHelloTo")
    public Mono<String> sayHelloToController(@Argument String name){
        return Mono.fromSupplier(()->"Hello " + name);
    }

    @QueryMapping("sayHelloThree")
    public Mono<String> sayHelloThreeController(@Argument("name") String value){
        return Mono.fromSupplier(()->"Hello " + value);
    }

    @QueryMapping("sayHelloToAge")
    public Mono<String> sayHelloAgeController(@Argument Integer age){
        return Mono.fromSupplier(()->"Hello " + age);
    }

    @QueryMapping("random")
    public Mono<Integer> random(){
        return Mono.just(ThreadLocalRandom.current().nextInt(1,100));
    }
}
