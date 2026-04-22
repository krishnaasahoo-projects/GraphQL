package com.learning.graphql_playground.lec06.service;

import com.learning.graphql_playground.lec06.dto.CustomerWithOrder;
import graphql.schema.DataFetchingFieldSelectionSet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.function.UnaryOperator;

@Service
@RequiredArgsConstructor
public class CustomerOrderDataFetcher {

    private final CustomerService customerService;
    private final OrderService orderService;

    @GetMapping("/customers")
    public Flux<CustomerWithOrder> customerOrders(DataFetchingFieldSelectionSet selectionSet){
        var includeOrders = selectionSet.contains("orders");
        return customerService.allCustomers()
                .map(c-> CustomerWithOrder.create(c.getId(),c.getName(),c.getAge(),c.getCity(), Collections.emptyList()))
                .transform(this.updateOrdersTransformer(includeOrders));
    }

    private UnaryOperator<Flux<CustomerWithOrder>> updateOrdersTransformer(boolean includeOrders){
        return includeOrders ? f-> f.flatMapSequential(this::fetchOrders):f->f;
    }

    private Mono<CustomerWithOrder> fetchOrders(CustomerWithOrder customerWithOrder){
        return this.orderService.orderByCustomerName(customerWithOrder.getName())
                .collectList()
                .doOnNext(customerWithOrder::setOrders)
                .thenReturn(customerWithOrder);
    }
}
