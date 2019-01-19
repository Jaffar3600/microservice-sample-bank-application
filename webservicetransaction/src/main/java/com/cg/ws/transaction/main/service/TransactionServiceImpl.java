package com.cg.ws.transaction.main.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ws.transaction.main.repository.TransactionRepository;
import com.cg.ws.transaction.main.transaction.Transaction;
import com.cg.ws.transaction.main.transaction.TransactionType;

@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	private TransactionRepository repo;
		
	
	 public double deposit(int accountNumber, double amount, double currentBalance, String transactionDetails) {
		 
		 Transaction transaction =new Transaction();
		 transaction.setAccountNumber(accountNumber);
		 currentBalance = currentBalance+amount;
		 transaction.setCurrentBalance(currentBalance);
		 transaction.setTransactionDetails(transactionDetails);
		 transaction.setTransactionType(TransactionType.DEPOSIT);
		 transaction.setTransactionDate(LocalDateTime.now());
		 repo.save(transaction);
		 return currentBalance;
	 }
}
