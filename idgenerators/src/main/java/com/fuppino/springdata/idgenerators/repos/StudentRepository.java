package com.fuppino.springdata.idgenerators.repos;

import org.springframework.data.repository.CrudRepository;

import com.fuppino.springdata.idgenerators.entities.Student;

public interface StudentRepository extends CrudRepository<Student,Long>{
	
}
