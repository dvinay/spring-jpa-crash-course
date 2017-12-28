package com.fuppino.springdata.idgenerators;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fuppino.springdata.idgenerators.entities.Employee;
import com.fuppino.springdata.idgenerators.entities.Student;
import com.fuppino.springdata.idgenerators.entities.User;
import com.fuppino.springdata.idgenerators.repos.EmployeeRepository;
import com.fuppino.springdata.idgenerators.repos.StudentRepository;
import com.fuppino.springdata.idgenerators.repos.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=IdGeneratorsApplication.class)
public class IdGeneratorsApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Test
	public void contextLoads() {
	}
	
	//Auto increment table test - IDENTITY
	@Test
	public void testCreateEmployee() {
		Employee employee = new Employee();
		employee.setName("Ram");
		employeeRepository.save(employee);
	}
	
	//placeholder table to store the data
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setName("Ram");
		userRepository.save(user);
	}
	
	//custom generator logic 
	@Test
	public void testCreateStudent() {
		Student student = new Student();
		student.setName("Ravana");
		studentRepository.save(student);
	}

}
