package com.learning.graphql_playground.lec14.service;

import com.learning.graphql_playground.lec14.dto.Customer;
import com.learning.graphql_playground.lec14.dto.CustomerEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
@RequiredArgsConstructor
public class CustomerEventService {

    private final Sinks.Many<CustomerEvent>sink = Sinks.many().multicast().onBackpressureBuffer();
    private final Flux<CustomerEvent>flux = sink.asFlux().cache(0);

    public void emitEvent(CustomerEvent event){
        this.sink.tryEmitNext(event);
    }

    public Flux<CustomerEvent> subscribe() {
        return this.flux;
    }
}
