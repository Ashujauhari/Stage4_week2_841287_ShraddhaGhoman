package com.cognizant.truyum.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoImpl;
import com.cognizant.truyum.model.MenuItem;
@Service
public class MenuItemService {

	@Autowired
	MenuItemDaoImpl MenuItemDaoCollectionImpl;
	
	public List<MenuItem> getMenuItemListCustomer(){
		return MenuItemDaoCollectionImpl.getMenuItemListCustomer();
	}

	public MenuItem getMenuItem(int id) throws SQLException {
		return MenuItemDaoCollectionImpl.getMenuItem(id);
	}
	
	public void modifyMenuItem(MenuItem menuItem) throws SQLException {
		MenuItemDaoCollectionImpl.modifyMenuItem(menuItem);
	}
	
	

}
