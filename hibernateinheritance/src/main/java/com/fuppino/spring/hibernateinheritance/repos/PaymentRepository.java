package com.fuppino.spring.hibernateinheritance.repos;

import org.springframework.data.repository.CrudRepository;

import com.fuppino.spring.hibernateinheritance.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
