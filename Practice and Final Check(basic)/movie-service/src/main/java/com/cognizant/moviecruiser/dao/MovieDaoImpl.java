package com.cognizant.moviecruiser.dao;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.moviecruiser.model.Movie;

@Repository
public class MovieDaoImpl {

	@Autowired
	MovieDao moviedao;

	@Transactional
	public List<Movie> getMovieListAdmin() {
		List<Movie> list=moviedao.getMovieListAdmin();
		return list;
	}

	@Transactional
	public List<Movie> getMovieListCustomer() {
		List<Movie> list=moviedao.getMovieListCustomer();
		return list;
	}

	@Transactional
	public void modifyMovie(Movie movie) {
		//Optional<Movie> res=moviedao.findById(movie.getId());
		Movie movie1=moviedao.getMovie(movie.getId());
		try {

			movie1.setTitle(movie.getTitle());
			movie1.setActive(movie.isActive());
			movie1.setBoxOffice(movie.getBoxOffice());
			movie1.setDateOfLaunch(movie.getDateOfLaunch());
			movie1.setGenre(movie.getGenre());
			movie1.setHasTeaser(movie.isHasTeaser());
			moviedao.save(movie1);
		}catch(Exception e) {
			moviedao.save(movie);

		}


	}

	@Transactional
	public Movie getMovie(int movieId) {
		Movie movie=moviedao.getMovie(movieId);
		return movie;
	}

}
