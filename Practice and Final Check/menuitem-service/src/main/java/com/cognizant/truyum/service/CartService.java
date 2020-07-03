package com.cognizant.truyum.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDaoImpl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.exception.CartEmptyException;

@Service
public class CartService {
	
	@Autowired
	CartDaoImpl cartDaoCollectionImpl;
	
	public void addCartItem(String userId, int menuItemId) throws ParseException {
		cartDaoCollectionImpl.addCartItem(userId, menuItemId);
	}

	public List<MenuItem> getAllCartItems(String userIds) throws CartEmptyException, SQLException{
		return cartDaoCollectionImpl.getAllCartItems(userIds);
	}
	
	public void removeCartItem(String userId, int menuItemId) {
		cartDaoCollectionImpl.removeCartItem(userId, menuItemId);
	}
}
