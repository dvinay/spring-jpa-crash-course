package com.fuppino.spring.associations.repos;

import org.springframework.data.repository.CrudRepository;

import com.fuppino.spring.associations.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long > {

}
