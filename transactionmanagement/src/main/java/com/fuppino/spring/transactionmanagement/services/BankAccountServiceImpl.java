package com.fuppino.spring.transactionmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fuppino.spring.transactionmanagement.entities.BankAccount;
import com.fuppino.spring.transactionmanagement.repos.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountRepository bankAccountRepository;

	@Override
	@Transactional
	public void transfer(int amount) {
		BankAccount obamaAccount = bankAccountRepository.findOne(1);
		obamaAccount.setBal(obamaAccount.getBal() - amount);
		bankAccountRepository.save(obamaAccount);

		if(true) {
			throw new RuntimeException("check acid");
		}
		BankAccount trumpAccount = bankAccountRepository.findOne(2);
		trumpAccount.setBal(trumpAccount.getBal() + amount);
		bankAccountRepository.save(trumpAccount);

	}
}