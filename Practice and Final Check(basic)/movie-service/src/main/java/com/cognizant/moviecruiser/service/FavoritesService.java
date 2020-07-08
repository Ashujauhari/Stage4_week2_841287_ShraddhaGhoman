package com.cognizant.moviecruiser.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.FavoritesDaoImpl;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.exception.FavoritesEmptyException;

@Service
public class FavoritesService {
	
	@Autowired
	FavoritesDaoImpl favoritesDaoImpl;
	
	public void addFavoritesMovie(String userId, int movieId) throws ParseException {
		favoritesDaoImpl.addFavoritesMovie(userId, movieId);
	}

	public List<Movie> getAllFavoritesMovies(String userIds) throws FavoritesEmptyException, SQLException{
		return favoritesDaoImpl.getAllFavoritesMovies(userIds);
	}
	
	public void removeFavoritesMovie(String userId, int movieId) {
		favoritesDaoImpl.removeFavoritesMovie(userId, movieId);
	}
}
