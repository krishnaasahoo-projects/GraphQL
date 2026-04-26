package com.learning.graphql_playground.lec14.util;

import com.learning.graphql_playground.lec14.dto.Customer;
import com.learning.graphql_playground.lec14.dto.CustomerDto;
import org.springframework.beans.BeanUtils;

public class EntityUtilDto {

    public static Customer toEntity(CustomerDto customerDto){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        return customer;
    }

    public static Customer toEntity(Integer id, CustomerDto customerDto){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customer.setId(id);
        return customer;
    }

    public static CustomerDto toDto(Customer customer){
        CustomerDto customerdto = new CustomerDto();
        BeanUtils.copyProperties(customer,customerdto);
        return customerdto;
    }
}
