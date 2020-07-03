package com.cognizant.moviecruiser.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.model.Movie;

public interface MovieDao extends JpaRepository<Movie,Integer>{
	
	@Query("select u from Movie u")
    public List<Movie> getMovieListAdmin();

	@Query("select u from Movie u where active=true")
	public List<Movie> getMovieListCustomer();

	@Query("select u from Movie u where id=?1")
	public Movie getMovie(int id);

	
}
