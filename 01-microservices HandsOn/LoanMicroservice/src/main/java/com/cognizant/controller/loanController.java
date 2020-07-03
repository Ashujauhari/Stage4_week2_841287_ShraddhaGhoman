package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.model.Loan;
import com.cognizant.service.loanServiceImpl;

@RestController
@RequestMapping("/")
public class loanController {

	@Autowired
	loanServiceImpl accountserviceImpl;
	
	@GetMapping("/loan/{number}")
	public Loan getAccount(@PathVariable String number) {
		return accountserviceImpl.getLoan(number);
	}
}
