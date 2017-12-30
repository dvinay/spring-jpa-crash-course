package com.fuppino.spring.associations.repos;

import org.springframework.data.repository.CrudRepository;

import com.fuppino.spring.associations.entities.License;

public interface LicenseRepository extends CrudRepository<License, Long > {

}
