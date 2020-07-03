package com.cognizant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter @NoArgsConstructor
public class Loan {
	private String number;
	private String type;
	private double loan;
	private double emi;
	private double tenure;
	public Loan(String number, String type, double loan, double emi, double tenure) {
		super();
		this.number = number;
		this.type = type;
		this.loan = loan;
		this.emi = emi;
		this.tenure = tenure;
	}
	

}
