package com.fuppino.spring.componentmapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fuppino.spring.componentmapping.entities.Address;
import com.fuppino.spring.componentmapping.entities.Employee;
import com.fuppino.spring.componentmapping.repo.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ComponentmappingApplication.class)
public class ComponentmappingApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreateEmployee() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Ram");
		Address address = new Address();
		address.setStreetaddress("1234 st");
		address.setCity("San Jose");
		address.setState("CA");
		address.setZipcode("94101");
		address.setCountry("USA");
		employee.setAddress(address);
		employeeRepository.save(employee);
	}

}
