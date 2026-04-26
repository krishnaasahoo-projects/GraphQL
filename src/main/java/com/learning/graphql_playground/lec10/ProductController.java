package com.learning.graphql_playground.lec10;

import com.learning.graphql_playground.lec10.dto.Book;
import com.learning.graphql_playground.lec10.dto.Electronics;
import com.learning.graphql_playground.lec10.dto.FruitDto;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.UUID;

@Controller
public class ProductController {

    @QueryMapping
    public Flux<Object> products(){
        return Flux.just(
                FruitDto.create(UUID.randomUUID(),"banana",1, LocalDate.now().plusDays(3).toString()),
                FruitDto.create(UUID.randomUUID(),"apple",10, LocalDate.now().plusDays(4).toString()),
                Book.create(UUID.randomUUID(),"java",40,"kk"),
                Electronics.create(UUID.randomUUID(),"mac book",600,"APPLE"),
                Electronics.create(UUID.randomUUID(),"phone",600,"SAM")
        );
    }
}
