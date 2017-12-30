package com.fuppino.spring.associations;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fuppino.spring.associations.entities.License;
import com.fuppino.spring.associations.entities.Person;
import com.fuppino.spring.associations.repos.LicenseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AssociationsApplication.class)
public class AssociationsApplicationTests {

	@Autowired
	LicenseRepository licenseRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testotooCreateLicense() {
		License license = new License();
		license.setType("CAR");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());
		
		Person person = new Person();
		person.setFirstName("Dipen");
		person.setLastName("Bhat");
		person.setAge(30);
		
		license.setPerson(person );
		licenseRepository.save(license);
	}
	
	
}
