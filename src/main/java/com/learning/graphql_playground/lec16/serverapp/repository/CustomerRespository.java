package com.learning.graphql_playground.lec16.serverapp.repository;

import com.learning.graphql_playground.lec16.dto.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRespository extends ReactiveCrudRepository<Customer,Integer> {
}
