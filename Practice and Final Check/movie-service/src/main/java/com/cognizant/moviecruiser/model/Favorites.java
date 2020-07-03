package com.cognizant.moviecruiser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class Favorites {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String us_id;
	
	@Column
	@JoinColumn(referencedColumnName = "mv_id")
	private int mv_id;

	public Favorites(String us_id, int mv_id) {
		super();
		this.us_id = us_id;
		this.mv_id = mv_id;
	}

	public Favorites(int id, String us_id, int mv_id) {
		super();
		this.id = id;
		this.us_id = us_id;
		this.mv_id = mv_id;
	}

	

}
