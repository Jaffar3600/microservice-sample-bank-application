package com.moneymoney.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.moneymoney.web.entity.Transaction;

@Controller
public class BankAppController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/DepositForm")
	public String depositForm() {
		return "DepositForm";
	}
	@RequestMapping("/deposit")
	public String deposit(@ModelAttribute Transaction transaction,
			Model model) {
		
		restTemplate.postForEntity("http://localhost:9898/transactions/deposit", 
				transaction, null);
		
		model.addAttribute("message","Success!");
		return "DepositForm";
	}

	@RequestMapping("/WithdrawForm")
	public String withdrawForm() {
		return "WithdrawForm";
	}
	@RequestMapping("/withdraw")
	public String withdraw(@ModelAttribute Transaction transaction,
			Model model) 
	{
		
		restTemplate.postForEntity("http://localhost:9898/transactions/withdraw", 
				transaction, null);
		
		model.addAttribute("message","Success!");
		return "WithdrawForm";
	}
	@RequestMapping("/FundTransfer")
	public String FundTransfer() {
		return "FundTransfer";
	}
	@RequestMapping("/fundTransfer")
	public String fundTransfer(@RequestParam("sender") int senderAccountNumber, @RequestParam("receiver") int receiverAccountNumber, @ModelAttribute Transaction transaction,Model model) {
		transaction.setAccountNumber(senderAccountNumber);
		restTemplate.postForEntity("http://localhost:9898/transactions/withdraw", 
				transaction, null);
		transaction.setAccountNumber(receiverAccountNumber);
		restTemplate.postForEntity("http://localhost:9898/transactions/deposit", 
				transaction, null);
		model.addAttribute("message","Success!");
		return "FundTransfer";
	}
	
	
}
