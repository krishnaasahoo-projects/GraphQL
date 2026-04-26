package com.learning.graphql_playground.lec11.controller;

import com.learning.graphql_playground.lec11.dto.Book;
import com.learning.graphql_playground.lec11.dto.Electronics;
import com.learning.graphql_playground.lec11.dto.FruitDto;
import com.learning.graphql_playground.lec11.enums.Brand;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

@Controller
public class SearchEngineController {

    List<Object> list = List.of(
            FruitDto.create("banana", LocalDate.now().plusDays(3).toString()),
            FruitDto.create("apple", LocalDate.now().plusDays(4).toString()),
            Book.create("java","KK"),
            Electronics.create(UUID.randomUUID(),"mac book",600, Brand.APPLE),
            Electronics.create(UUID.randomUUID(),"phone",600,Brand.SAMSUNG)
    );

    @QueryMapping
    public Flux<Object> search(){
        return Mono.fromSupplier(()-> new ArrayList<>(list))
                .doOnNext(Collections::shuffle)
                .flatMapIterable(Function.identity())
                .take(ThreadLocalRandom.current().nextInt(0, list.size()));
    }
}
