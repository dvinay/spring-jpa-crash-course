package com.fuppino.spring.transactionmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.fuppino.spring.transactionmanagement.entities.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer>{
	
}