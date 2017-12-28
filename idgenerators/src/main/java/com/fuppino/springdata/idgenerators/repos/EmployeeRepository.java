package com.fuppino.springdata.idgenerators.repos;

import org.springframework.data.repository.CrudRepository;

import com.fuppino.springdata.idgenerators.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{
	
}
