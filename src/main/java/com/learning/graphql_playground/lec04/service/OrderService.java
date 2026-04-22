package com.learning.graphql_playground.lec04.service;

import com.learning.graphql_playground.lec04.dto.CustomerOrderDto;
import io.netty.util.internal.ThreadLocalRandom;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
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
            ),
            "gp",List.of(
                    CustomerOrderDto.create(UUID.randomUUID(),"gp-1"),
                    CustomerOrderDto.create(UUID.randomUUID(),"gp-2"),
                    CustomerOrderDto.create(UUID.randomUUID(),"gp-3")
            )
    );

    public Flux<CustomerOrderDto> orderByCustomerName(String name){
        return Flux.fromIterable(map.getOrDefault(name, Collections.emptyList()));
    }

//    public Flux<List<CustomerOrderDto>> orderByCustomerName(List<String> name){
//        return Flux.fromIterable(name).map(n-> map.getOrDefault(n,Collections.emptyList()));
//    }

    public Flux<List<CustomerOrderDto>> orderByCustomerName(List<String> name){
        return Flux.fromIterable(name).flatMapSequential(n->fetchOrders(n).defaultIfEmpty(Collections.emptyList()));
    }

    private Mono<List<CustomerOrderDto>> fetchOrders(String name){
        return Mono.justOrEmpty(map.get(name)).delayElement(Duration.ofMillis(ThreadLocalRandom.current().nextInt(0,500)));
    }
}
