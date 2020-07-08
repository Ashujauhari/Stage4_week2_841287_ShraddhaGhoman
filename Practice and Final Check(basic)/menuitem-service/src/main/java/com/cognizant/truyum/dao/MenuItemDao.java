package com.cognizant.truyum.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao extends JpaRepository<MenuItem,Integer>{
	@Query("select u from MenuItem u")
	List<MenuItem> getMenuItemListAdmin();

	@Query("select u from MenuItem u where active= true ")
	List<MenuItem> getMenuItemListCustomer();
	

	@Query("select u from MenuItem u where id=?1")
	MenuItem getMenuItem(int menuItemId) throws SQLException;
	//public Optional<MenuItem> findById(int id);


}
