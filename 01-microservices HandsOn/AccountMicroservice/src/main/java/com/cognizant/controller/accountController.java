package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Account;
import com.cognizant.service.accountServiceImpl;

@RestController
@RequestMapping("/")
public class accountController {

	@Autowired
	accountServiceImpl accountserviceImpl;
	
	@GetMapping("/account/{number}")
	public Account getAccount(@PathVariable String number) {
		return accountserviceImpl.getAccount(number);
	}
}
