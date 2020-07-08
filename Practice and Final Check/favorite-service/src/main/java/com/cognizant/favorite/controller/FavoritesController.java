package com.cognizant.favorite.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.favorite.model.Movie;
import com.cognizant.favorite.service.FavoritesService;
import com.cognizant.favorite.service.exception.FavoritesEmptyException;

import lombok.extern.slf4j.Slf4j;
@RestController @Slf4j
@RequestMapping("/favorites")
public class FavoritesController {

	@Autowired
	FavoritesService favService;
	
	@GetMapping("/{userId}")
    List<Movie> getAllFavoritesMovies(@PathVariable String userId) throws FavoritesEmptyException, SQLException {
		return favService.getAllFavoritesMovies(userId);
	}

	@PostMapping("/{userId}/{movieId}")
	void addFavoritesMovie(@PathVariable String userId,@PathVariable int movieId) throws ParseException {
		favService.addFavoritesMovie(userId, movieId);
	}
	
	@DeleteMapping("/{userId}/{movieId}")
	void removeFavoritesMovie(@PathVariable String userId,@PathVariable int movieId) {
		favService.removeFavoritesMovie(userId, movieId);
	}
}
