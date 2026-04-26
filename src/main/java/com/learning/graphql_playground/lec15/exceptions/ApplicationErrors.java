package com.learning.graphql_playground.lec15.exceptions;

import org.springframework.graphql.execution.ErrorType;
import reactor.core.publisher.Mono;

import java.util.Map;

public class ApplicationErrors {

    public static <T> Mono<T> noSuchUser(Integer id){
        return Mono.error(new ApplicationException(
                ErrorType.BAD_REQUEST, "NO SUCH USER", Map.of(
                        "cutomerId",id
        )));
    }
}
