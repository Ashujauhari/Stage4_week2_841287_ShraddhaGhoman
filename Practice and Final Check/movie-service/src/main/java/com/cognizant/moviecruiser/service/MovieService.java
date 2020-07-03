package com.cognizant.moviecruiser.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.MovieDaoImpl;
import com.cognizant.moviecruiser.model.Movie;
@Service
public class MovieService {

	@Autowired
	MovieDaoImpl movieDaoImpl;
	
	public List<Movie> getMovieListCustomer(){
		return movieDaoImpl.getMovieListCustomer();
	}

	public Movie getMovie(int id) throws SQLException {
		return movieDaoImpl.getMovie(id);
	}
	
	public void modifyMovie(Movie movie) throws SQLException {
		movieDaoImpl.modifyMovie(movie);
	}
	
	

}
