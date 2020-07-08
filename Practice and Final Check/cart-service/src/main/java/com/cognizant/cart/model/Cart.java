package com.cognizant.cart.model;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor 
@Entity
public class Cart {
	
	@Id
	private int id;


	@Column
	private String us_id;
	
	@Column
	private int c_id;
	
	
	public Cart(String us_id, int c_id) {
		super();
		this.us_id = us_id;
		this.c_id = c_id;
	}


}
