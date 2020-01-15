package com.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.models.Restaurant;

@CrossOrigin(
origins = "*", 
allowedHeaders = "*", 
methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public interface RestaurantRepository extends CrudRepository<Restaurant, String> {
	
	@Override
	void delete(Restaurant deleted);
}
