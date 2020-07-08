package com.cognizant.moviecruiser.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "boxoffice")
	private String boxOffice;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "dateoflaunch")
	private Date dateOfLaunch;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "hasteaser")
	private boolean hasTeaser;
	


	public Movie(int id, String title, String boxOffice, boolean active, Date dateOfLaunch,
			String genre, boolean hasTeaser) {
		super();
		this.id = id;
		this.title = title;
		this.boxOffice = boxOffice;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
	}


}
