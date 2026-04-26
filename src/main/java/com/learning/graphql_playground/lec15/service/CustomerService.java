package com.learning.graphql_playground.lec15.service;

import com.learning.graphql_playground.lec15.dto.CustomerDto;
import com.learning.graphql_playground.lec15.dto.DeleteResponseDto;
import com.learning.graphql_playground.lec15.enums.Status;
import com.learning.graphql_playground.lec15.repository.CustomerRespository;
import com.learning.graphql_playground.lec15.util.EntityUtilDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRespository customerRespository;


    public Flux<CustomerDto> allCustomers(){
        return this.customerRespository.findAll()
                .map(EntityUtilDto::toDto);
    }

    public Mono<CustomerDto> customerById(Integer id){
        return this.customerRespository.findById(id).map(EntityUtilDto::toDto);
    }

    public Mono<CustomerDto> createCustomer(CustomerDto customerDto){
        return Mono.just(customerDto)
                .map(EntityUtilDto::toEntity)
                .flatMap(this.customerRespository::save)
                .map(EntityUtilDto::toDto);
    }

    public Mono<CustomerDto> updateCustomer(Integer id, CustomerDto customerDto){
        return Mono.just(customerDto)
                .map(c-> EntityUtilDto.toEntity(id,customerDto))
                .flatMap(this.customerRespository::save)
                .map(EntityUtilDto::toDto);
    }

    public Mono<DeleteResponseDto> deleteCustomer(Integer id){
        return this.customerRespository.deleteById(id)
                .thenReturn(DeleteResponseDto.create(id, Status.SUCCESS))
                .onErrorReturn(DeleteResponseDto.create(id, Status.FAILURE));
    }


}
