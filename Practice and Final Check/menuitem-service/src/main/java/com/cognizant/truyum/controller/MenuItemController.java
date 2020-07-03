package com.cognizant.truyum.controller;

import java.sql.SQLException;
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
@RestController
@RequestMapping("/menuitems")
public class MenuItemController {

	@Autowired
	MenuItemService menuItemService;
	
	@GetMapping
	public List<MenuItem>getAllMenuItems(){
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
