package com.cg.ws.transaction.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ws.transaction.main.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
