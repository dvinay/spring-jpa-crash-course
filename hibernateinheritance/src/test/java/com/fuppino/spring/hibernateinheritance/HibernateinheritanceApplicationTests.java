package com.fuppino.spring.hibernateinheritance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fuppino.spring.hibernateinheritance.entities.Check;
import com.fuppino.spring.hibernateinheritance.entities.CreditCard;
import com.fuppino.spring.hibernateinheritance.repos.PaymentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HibernateinheritanceApplication.class)
public class HibernateinheritanceApplicationTests {

	@Autowired
	PaymentRepository paymentRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreateCreditCardSingleTable() {
		CreditCard creditCard = new CreditCard();
		creditCard.setId(123);
		creditCard.setCardnumber("1234567890");
		creditCard.setAmount(34.56);
		paymentRepository.save(creditCard);		
	}
	
	@Test
	public void testCheckSingleTable() {
		Check check = new Check();
		check.setId(124);
		check.setChecknumber("1234567890");
		check.setAmount(100.00);
		paymentRepository.save(check);
	}
}
