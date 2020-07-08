package com.cognizant.favorite.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.favorite.model.Favorites;
import com.cognizant.favorite.model.Movie;
import com.cognizant.favorite.service.exception.FavoritesEmptyException;
import com.feignproxy.MoviecruiserServiceProxy;

@Repository
public class FavoritesDaoImpl {

	@Autowired
	FavoritesDao favoriteDao;
	
	@Autowired
	@Lazy MoviecruiserServiceProxy proxy;
	
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
			Movie movie1=proxy.getMovie(i);
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
