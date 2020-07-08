package com.cognizant.cart.controller;

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

import com.cognizant.cart.model.Cart;
import com.cognizant.cart.model.MenuItem;
import com.cognizant.cart.service.CartService;
import com.cognizant.cart.service.exception.CartEmptyException;
import com.feignproxy.MenuItemServiceProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;
@RestController @Slf4j
@RequestMapping("/carts")
public class CartController {

	@Autowired
	CartService cartService;
	
	@HystrixCommand(fallbackMethod = "fallback_method")
	@GetMapping("/{userId}")
    List<MenuItem> getAllCartItems(@PathVariable("userId") String userId) throws CartEmptyException, SQLException {
		return cartService.getAllCartItems(userId);
	}
	 public List<MenuItem> fallback_method(@PathVariable("userId") String userId) throws CartEmptyException, SQLException{
		 log.debug("Fallback method start");
		 log.debug("Request fails. It takes long time to response.");
		 log.debug("Fallback method end");
		return new ArrayList<MenuItem>();
	   }
	@PostMapping("/{userId}/{menuItemId}")
	void addCartItem(@PathVariable String userId,@PathVariable int menuItemId) throws ParseException {
		cartService.addCartItem(userId, menuItemId);
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	void removeCartItem(@PathVariable String userId,@PathVariable int menuItemId) {
		cartService.removeCartItem(userId, menuItemId);
	}
	
	
	
}
