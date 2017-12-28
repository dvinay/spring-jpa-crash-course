package com.fuppino.springdata.idgenerators;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fuppino.springdata.idgenerators.entities.Employee;
import com.fuppino.springdata.idgenerators.entities.User;
import com.fuppino.springdata.idgenerators.repos.EmployeeRepository;
import com.fuppino.springdata.idgenerators.repos.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=IdGeneratorsApplication.class)
public class IdGeneratorsApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreateEmployee() {
		Employee employee = new Employee();
		employee.setName("Ram");
		employeeRepository.save(employee);
	}
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setName("Ram");
		userRepository.save(user);
	}

}
