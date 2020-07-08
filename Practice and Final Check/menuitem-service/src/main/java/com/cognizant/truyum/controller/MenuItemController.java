package com.cognizant.truyum.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import lombok.extern.slf4j.Slf4j;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


@RestController
@RequestMapping("/menuitems")
@Slf4j
public class MenuItemController {

	@Autowired
	MenuItemService menuItemService;
	
	
	@GetMapping
	public List<MenuItem> getAllMenuItems() throws InterruptedException{
		return menuItemService.getMenuItemListCustomer();
	}
	
	
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable int id) throws SQLException {
		return menuItemService.getMenuItem(id);
	}
	
	@PutMapping()
	public void modifyMenuItem(@RequestBody MenuItem menuItem) throws SQLException {
		menuItemService.modifyMenuItem(menuItem);
	}
}
