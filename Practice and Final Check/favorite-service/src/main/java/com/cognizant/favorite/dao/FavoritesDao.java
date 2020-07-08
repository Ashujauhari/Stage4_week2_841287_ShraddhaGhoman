package com.cognizant.favorite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.favorite.model.Favorites;
import com.cognizant.favorite.service.exception.FavoritesEmptyException;

public interface FavoritesDao extends JpaRepository<Favorites,Integer> {


	@Query("select f.mv_id from Favorites f where us_id=?1")
	public List<Integer> getAllFavoritesMovies(String userId) throws FavoritesEmptyException;

	@Modifying
	@Query("delete from Favorites f where f.us_id=?1 and f.mv_id=?2")
    public void removeFavoritesMovie(String userId, int movieId);
	
	@Query("select count(f.id) from Favorites f where f.us_id=?1")
	public int getCount(String userId);
}
