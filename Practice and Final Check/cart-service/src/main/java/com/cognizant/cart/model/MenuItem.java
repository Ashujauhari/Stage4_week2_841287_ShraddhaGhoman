package com.cognizant.cart.model;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter @Setter @NoArgsConstructor @ToString
@Entity
@Table(name = "menuitem")
public class MenuItem {
	
	@Id
	int id;
	String name;
	float price;
	boolean active;
	Date dateoflaunch;
	String category;
	boolean freedelivery;

	public MenuItem(int id, String name, float price, boolean active, Date dateOfLaunch, String category,
			boolean freeDelivery) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateoflaunch = dateOfLaunch;
		this.category = category;
		this.freedelivery = freeDelivery;
	}
	
}
