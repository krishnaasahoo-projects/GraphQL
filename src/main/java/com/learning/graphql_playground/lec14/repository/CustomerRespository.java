package com.learning.graphql_playground.lec14.repository;

import com.learning.graphql_playground.lec14.dto.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRespository extends ReactiveCrudRepository<Customer,Integer> {
}
