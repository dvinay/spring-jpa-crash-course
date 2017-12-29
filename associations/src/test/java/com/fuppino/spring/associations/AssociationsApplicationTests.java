package com.fuppino.spring.associations;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fuppino.spring.associations.entities.Customer;
import com.fuppino.spring.associations.entities.PhoneNumber;
import com.fuppino.spring.associations.repos.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AssociationsApplication.class)
public class AssociationsApplicationTests {

	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setName("Ram");
		
		Set<PhoneNumber> numbers = new HashSet<>();
		
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("1234567890");
		ph1.setType("Home");
		ph1.setCustomer(customer);
		numbers.add(ph1);
		
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("0987654321");
		ph2.setType("Mobile");
		ph2.setCustomer(customer);
		numbers.add(ph2);
		
		customer.setNumbers(numbers);
		
		customerRepository.save(customer);
	}
	
	@Test
	public void testCreateCustomer2() {
		Customer customer = new Customer();
		customer.setName("Ravana");
		
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("1234567890");
		ph1.setType("Home");
		customer.addNumber(ph1);
		
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("0987654321");
		ph2.setType("Mobile");
		customer.addNumber(ph2);
		
		customerRepository.save(customer);
	}

}
