package com.feignproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.cognizant.cart.model.MenuItem;


@FeignClient(name ="menuitem-service",url = "localhost:8082/menuitems")
public interface MenuItemServiceProxy {
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable int id);
}
