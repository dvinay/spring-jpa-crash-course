package com.fuppino.spring.associations.repos;

import org.springframework.data.repository.CrudRepository;

import com.fuppino.spring.associations.entities.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer > {

}
