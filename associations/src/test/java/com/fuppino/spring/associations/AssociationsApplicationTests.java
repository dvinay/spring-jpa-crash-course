package com.fuppino.spring.associations;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fuppino.spring.associations.entities.Customer;
import com.fuppino.spring.associations.entities.PhoneNumber;
import com.fuppino.spring.associations.repos.CustomerRepository;
import com.fuppino.spring.associations.repos.PhoneNumberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AssociationsApplication.class)
public class AssociationsApplicationTests {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	PhoneNumberRepository phoneNumberRepository;
	
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
	
	@Test
	@Transactional
	public void testLoadCustomer() {
		Customer customer = customerRepository.findOne(2L);
		System.out.println("Customer : "+customer.getName());
		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(System.out::println);
	}
	
	@Test
	@Transactional
	public void testLoadPhoneNumber() {
		PhoneNumber phoneNumber = phoneNumberRepository.findOne(3);
		System.out.println("Phone Number : "+phoneNumber);
		System.out.println("Customer : "+phoneNumber.getCustomer());
	}
	
	@Test
	public void testUpdateCustomer() {
		Customer customer = customerRepository.findOne(2L);
		customer.setName("Laxman");
		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(p -> p.setType("cell"));
	
		customerRepository.save(customer);
	}
}
