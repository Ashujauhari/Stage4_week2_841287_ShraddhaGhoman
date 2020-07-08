package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.exception.FavoritesEmptyException;

@Repository
public class FavoritesDaoImpl {

	@Autowired
	FavoritesDao favoriteDao;
	
	@Autowired
	MovieDao movieDao;
	
	@Transactional
	public void addFavoritesMovie(String userId, int movieId) {
		Favorites fav=new Favorites(userId,movieId);
		favoriteDao.save(fav);
		
	}
	
	@Transactional
	public List<Movie> getAllFavoritesMovies(String userId) throws FavoritesEmptyException {
		List<Integer> list=favoriteDao.getAllFavoritesMovies(userId);
		List<Movie> movie=new ArrayList<Movie>();
		for (Integer i : list) {
			Movie movie1=movieDao.getMovie(i);
			movie.add(movie1);
		}
		return movie;
	}

	@Transactional
	public void removeFavoritesMovie(String userId, int movieId) {
		favoriteDao.removeFavoritesMovie(userId, movieId);
	}
	
	@Transactional
	public int getCount(String userId) {
		return favoriteDao.getCount(userId);
	}

}
