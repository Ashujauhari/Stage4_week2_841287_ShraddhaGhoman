package com.cognizant.cart.dao;
import com.cognizant.cart.model.*;
import com.cognizant.cart.service.exception.CartEmptyException;
import com.feignproxy.MenuItemServiceProxy;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class CartDaoImpl{
	
	@Autowired
	@Lazy MenuItemServiceProxy proxy;
	
	@Autowired
	CartDao cartDao;


	
	@Transactional
	public void addCartItem(String userId, int menuItemId) throws ParseException{
		Cart cart=new Cart(userId, menuItemId);
		cartDao.save(cart);
	}


	@Transactional
	public List<MenuItem> getAllCartItems(String userId) throws CartEmptyException, SQLException {
		List<Integer> list=cartDao.getAllCartItems(userId);
		List<MenuItem> menu=new ArrayList<MenuItem>();
		for (Integer i : list) {
			MenuItem movie1=proxy.getMenuItem(i);
			menu.add(movie1);
		}
		return menu;
	}


	@Transactional
	public void removeCartItem(String userId, int menuItemId) {
		// TODO Auto-generated method stub
		cartDao.removeCartItem(userId, menuItemId);
	}

	@Transactional
	public int getTotal(String userId)
	{
		return cartDao.getTotal(userId);
	}



}





