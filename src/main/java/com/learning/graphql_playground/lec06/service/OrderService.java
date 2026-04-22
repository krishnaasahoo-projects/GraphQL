package com.learning.graphql_playground.lec06.service;

import com.learning.graphql_playground.lec06.dto.CustomerOrderDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {

    private final Map<String, List<CustomerOrderDto>> map = Map.of(
            "kk",List.of(
                    CustomerOrderDto.create(UUID.randomUUID(),"kk-1"),
                    CustomerOrderDto.create(UUID.randomUUID(),"kk-2")
            )
//            ,
//            "gp",List.of(
//                    CustomerOrderDto.create(UUID.randomUUID(),"gp-1"),
//                    CustomerOrderDto.create(UUID.randomUUID(),"gp-2"),
//                    CustomerOrderDto.create(UUID.randomUUID(),"gp-3")
//            )
    );


    public Flux<CustomerOrderDto> orderByCustomerName(String name){
        return Flux.fromIterable(map.getOrDefault(name,Collections.emptyList()))
                .doOnNext(o->print("orders for "+name));
    }

    private void print(String name){
        System.out.println(LocalDateTime.now() + name);
    }
}
