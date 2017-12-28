package com.fuppino.springdata.entities.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fuppino.springdata.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
	@Query("from Student")
	List<Student> findAllStudents();
	
	@Query("select st.firstName, st.lastName from Student st")
	List<Object[]> findAllStudentsPartialData();
	
	@Query("from Student where firstName=:firstName")
	List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);
	
	@Query("from Student where score>:min and score<:max")
	List<Student> findAllStudentsForGivenScoreRange(@Param("min") int min,@Param("max") int max);
	
	@Modifying
	@Query("delete from Student where firstName=:firstName")
	void deletStudentsForGivenFirstName(@Param("firstName") String firstName);
}