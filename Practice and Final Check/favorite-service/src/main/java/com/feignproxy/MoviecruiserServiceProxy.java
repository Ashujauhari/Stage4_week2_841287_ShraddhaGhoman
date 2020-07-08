package com.feignproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.favorite.model.Movie;


@FeignClient(name = "movie-service",url = "localhost:8083/movies")
public interface MoviecruiserServiceProxy {

	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable int id);
}
