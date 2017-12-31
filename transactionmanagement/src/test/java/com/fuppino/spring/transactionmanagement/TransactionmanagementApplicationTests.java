package com.fuppino.spring.transactionmanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fuppino.spring.transactionmanagement.services.BankAccountService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TransactionmanagementApplication.class)
public class TransactionmanagementApplicationTests {

	@Autowired
	BankAccountService service;
	
	@Test
	public void testTransfer() {
		service.transfer(500);
	}

}
