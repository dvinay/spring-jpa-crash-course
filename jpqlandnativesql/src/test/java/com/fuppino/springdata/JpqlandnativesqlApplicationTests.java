package com.fuppino.springdata;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.fuppino.springdata.entities.Student;
import com.fuppino.springdata.entities.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpqlandnativesqlApplication.class)
public class JpqlandnativesqlApplicationTests {

	@Autowired
	StudentRepository studentRepository;
	
	@Test
	public void testStudent() {
		List<Student> students = studentRepository.findAllStudents();
		students.forEach(p -> System.out.println(p));
	}
	
	@Test
	public void testStudentPageable() {
		Pageable pageable = new PageRequest(0, 2);
		List<Student> students = studentRepository.findAllStudents(pageable);
		students.forEach(p -> System.out.println(p));
	}
	
	@Test
	public void testStudentsPartialData() {
		List<Object[]> students = studentRepository.findAllStudentsPartialData();
		for(Object[] objects: students) {
			System.out.println(objects[0] +" "+ objects[1]);
		}
	}
	
	@Test
	public void testFindAllStudentsByFirstName() {
		List<Student> students = studentRepository.findAllStudentsByFirstName("mac");
		students.forEach(p -> System.out.println(p));
	}
	
	@Test
	public void testFindAllStudentsForGivenScoreRange() {
		List<Student> students = studentRepository.findAllStudentsForGivenScoreRange(70, 90);
		students.forEach(p -> System.out.println(p));
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testDeletStudentsForGivenFirstName() {
		studentRepository.deletStudentsForGivenFirstName("mac");
	}

}
