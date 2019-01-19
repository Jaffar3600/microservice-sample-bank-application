package com.cg.ws.transaction.main.service;

public interface TransactionService {
	 double deposit(int accountNumber, double amount, double currentBalance,
			 String transactionDetails);
		 
}