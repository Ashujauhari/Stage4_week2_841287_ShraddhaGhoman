package com.cognizant.cart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.cart.model.*;
import com.cognizant.cart.service.exception.CartEmptyException;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer>{
 
	
	@Query("select f.c_id from Cart f where us_id=?1")
	List<Integer> getAllCartItems(String userId) throws CartEmptyException;
	
	 @Modifying
	 @Query("delete from Cart f where f.us_id=?1 and f.c_id=?2")
	void removeCartItem(String userId, int menuItemId);
	 
	 @Query("select sum(m.price) from Cart c, MenuItem m where c.c_id=m.id ")
	 public int getTotal(String userId);
}
