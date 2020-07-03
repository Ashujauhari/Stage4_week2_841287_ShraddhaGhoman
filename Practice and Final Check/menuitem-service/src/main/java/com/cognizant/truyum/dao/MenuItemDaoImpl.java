package com.cognizant.truyum.dao;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.truyum.model.*;

import lombok.extern.slf4j.Slf4j;
@Repository
public class MenuItemDaoImpl{
	
	@Autowired
	MenuItemDao menuItemDao;
	List<MenuItem> menuItemList=null;
    
	

	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {
		menuItemList=menuItemDao.getMenuItemListAdmin();
		return menuItemList;
	}

	@Transactional
    public List<MenuItem> getMenuItemListCustomer() {
		
		List<MenuItem> custList=menuItemDao.getMenuItemListCustomer();
		return custList;
	}

	@Transactional
	public void modifyMenuItem(MenuItem menuItem) throws SQLException {
		
		//Optional<MenuItem> res=menuItemDao.findById(menuItem.getId());
		try {
		MenuItem menuitem1=menuItemDao.getMenuItem(menuItem.getId());
		menuitem1.setActive(menuItem.isActive());
		menuitem1.setCategory(menuItem.getCategory());
		menuitem1.setDateoflaunch(menuItem.getDateoflaunch());
		menuitem1.setFreedelivery(menuItem.isFreedelivery());
		menuitem1.setName(menuItem.getName());
		menuitem1.setPrice(menuItem.getPrice());
		menuItemDao.save(menuitem1);
		}
		catch(Exception e)
		{
			menuItemDao.save(menuItem);
		}
		
	}

	
	@Transactional
    public MenuItem getMenuItem(int menuItemId) throws SQLException {
		MenuItem tempItem=menuItemDao.getMenuItem(menuItemId);
		return tempItem;
	}
	
	

}
