package com.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.models.Reservation;

@CrossOrigin(
origins = "*", 
allowedHeaders = "*", 
methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public interface ReservationRepository extends CrudRepository<Reservation, String> {
	
	@Override
	void delete(Reservation deleted);
	
	
	

}
