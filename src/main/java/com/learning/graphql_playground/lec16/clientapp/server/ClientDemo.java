package com.learning.graphql_playground.lec16.clientapp.server;

import com.learning.graphql_playground.lec16.clientapp.client.CustomerClient;
import com.learning.graphql_playground.lec16.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
public class ClientDemo implements CommandLineRunner {

    @Autowired
    private CustomerClient client;

    @Override
    public void run(String... args) throws Exception {
        rawQueryDemo().then(this.getCustomerById()).subscribe();
    }

    private Mono<Void> rawQueryDemo(){
        String query = """
                {
                customers{
                    id
                    name
                    age
                    city
                  }
                }
                """;
        Mono<List<CustomerDto>> mono = this.client.rawQuery(query)
                .map(cr->cr.field("customers")
                        .toEntityList(CustomerDto.class));
        return this.executer("Raw Query",mono);
//        return Mono.delay(Duration.ofSeconds(1))
//                .doFirst(()-> System.out.println("Raw Query"))
//                .then(mono)
//                .doOnNext(System.out::println)
//                .then();
    }

    private Mono<Void> getCustomerById(){
        return this.executer("Raw Query 2",this.client.getCustomerById(1));
//        return Mono.delay(Duration.ofSeconds(1))
//                .doFirst(()-> System.out.println("Raw Query 2"))
//                .then(this.client.getCustomerById(1))
//                .doOnNext(System.out::println)
//                .then();
    }

    private <T> Mono<Void> executer(String message, Mono<T> mono){
        return Mono.delay(Duration.ofSeconds(1))
                .doFirst(()-> System.out.println(message))
                .then(mono)
                .doOnNext(System.out::println)
                .then();
    }

//    private Mono<Void> rawQueryDemo(){
//        String query = """
//                {
//                a:customers{
//                    id
//                    name
//                    age
//                    city
//                  }
//                }
//                """;
//        Mono<List<CustomerDto>> mono = this.client.rawQuery(query)
//                .map(cr->cr.field("a")
//                        .toEntityList(CustomerDto.class));
//        return Mono.delay(Duration.ofSeconds(1))
//                .doFirst(()-> System.out.println("Raw Query"))
//                .then(mono)
//                .doOnNext(System.out::print)
//                .then();
//    }
}
