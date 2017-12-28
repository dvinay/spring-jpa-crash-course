package com.fuppino.springdata.entities.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fuppino.springdata.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
	@Query("from Student")
	List<Student> findAllStudents();
}