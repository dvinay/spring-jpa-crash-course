package com.fuppino.spring.componentmapping.repo;

import org.springframework.data.repository.CrudRepository;

import com.fuppino.spring.componentmapping.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
}