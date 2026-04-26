package com.learning.graphql_playground.lec13.repository;

import com.learning.graphql_playground.lec13.dto.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRespository extends ReactiveCrudRepository<Customer,Integer> {
}
