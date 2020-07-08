package com.cognizant.moviecruiser.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@HystrixCommand(fallbackMethod = "fallback_method")
	@GetMapping
	public List<Movie>getMovieListCustomer(){
		return movieService.getMovieListCustomer();
	}
	
	private List<Movie> fallback_method() {
		 log.debug("Fallback method start");
		 log.debug("Request fails. It takes long time to response.");
		 log.debug("Fallback method end");
		return new ArrayList<Movie>();
	   }
	
	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable int id) throws SQLException {
		return movieService.getMovie(id);
	}
	

	
	@PutMapping()
	public void modifyMovie(@RequestBody Movie movie) throws SQLException {
		movieService.modifyMovie(movie);
	}
}
