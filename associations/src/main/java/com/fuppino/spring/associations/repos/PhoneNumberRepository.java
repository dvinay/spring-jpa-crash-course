package com.fuppino.spring.associations.repos;

import org.springframework.data.repository.CrudRepository;

import com.fuppino.spring.associations.entities.PhoneNumber;

public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Integer> {

}
