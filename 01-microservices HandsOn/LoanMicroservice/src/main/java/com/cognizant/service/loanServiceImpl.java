package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.cognizant.model.Loan;

@Repository
public class loanServiceImpl implements loanService{

	@Override
	public Loan getLoan(String number) {
		List<Loan> list=new ArrayList<>();
		Loan loan1=new Loan("10987987973432","car",400000,3258,18);
		list.add(loan1);
		return loan1;
	}

}
