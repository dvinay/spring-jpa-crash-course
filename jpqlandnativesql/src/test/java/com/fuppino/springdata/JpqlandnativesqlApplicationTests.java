package com.fuppino.springdata;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fuppino.springdata.entities.Student;
import com.fuppino.springdata.entities.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpqlandnativesqlApplication.class)
public class JpqlandnativesqlApplicationTests {

	@Autowired
	StudentRepository studentRepository;
	
	@Test
	public void contextLoads() {
		List<Student> students = studentRepository.findAllStudents();
		students.forEach(p -> System.out.println(p));
	}

}
