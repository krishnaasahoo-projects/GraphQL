package com.learning.graphql_playground.lec06.controller;


import com.learning.graphql_playground.lec06.dto.CustomerOrderDto;
import com.learning.graphql_playground.lec06.dto.CustomerWithOrder;
import com.learning.graphql_playground.lec06.service.CustomerService;
import com.learning.graphql_playground.lec06.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class CustomerRestController {

    private final CustomerService customerService;
    private final OrderService orderService;

    @GetMapping("/customers")
    public Flux<CustomerWithOrder> customerOrders(){
        return customerService.allCustomers()
                .flatMap(c -> orderService.orderByCustomerName(c.getName())
                    .collectList()
                    .map(l->
                            CustomerWithOrder.create(c.getId(),c.getName(),c.getAge(),c.getCity(),l)));
    }
}
