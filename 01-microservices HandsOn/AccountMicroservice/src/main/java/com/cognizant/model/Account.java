package com.cognizant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter @NoArgsConstructor
public class Account {	
	private String number;
	private String type;
	private double balance;
	public Account(String number, String type, double balance) {
		super();
		this.number = number;
		this.type = type;
		this.balance = balance;
	}
	
	
	

}
