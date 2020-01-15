package com.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.repositories.ReservationRepository;
import com.models.Reservation;

@RestController
@CrossOrigin(
origins = "*", 
allowedHeaders = "*", 
methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ReservationController {
	
	@Autowired
	ReservationRepository reservationRespository;
	
	@RequestMapping(method=RequestMethod.GET, value="/api/reservations")
	public Iterable<Reservation> reservation() {
		return reservationRespository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/api/reservations")
	public String save(@RequestBody Reservation reservation) {
		reservationRespository.save(reservation);
		
		return reservation.getId();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/api/reservation/{id}")
	public Optional<Reservation> show(@PathVariable String id, @RequestBody Reservation rsv){
		return reservationRespository.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/api/reservations/{id}")
	public Reservation update(@PathVariable String id, @RequestBody Reservation reservation) {
		Optional<Reservation> rsv = reservationRespository.findById(id);
			if(reservation.getId() != null)
				rsv.get().setId(reservation.getId());
			if(reservation.getNumberOfPeople() != null)
				rsv.get().setNumberOfPeople(reservation.getNumberOfPeople());
			if(reservation.getReservationDate() != null)
				rsv.get().setReservationDate(reservation.getReservationDate());
			if(reservation.getReservationHour() != null)
				rsv.get().setReservationHour(reservation.getReservationHour());
			if(reservation.getRestaurantId() != null)
				rsv.get().setRestaurantId(reservation.getRestaurantId());
			if(reservation.getUserId() != null) 
				rsv.get().setUserId(reservation.getUserId());
			if(reservation.getIsCanceled() != false)
				rsv.get().setIsCanceled(reservation.getIsCanceled());
			return rsv.get();
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/api/reservations/{id}")
	public String delete(@PathVariable String id) {
		Optional<Reservation> reservation = reservationRespository.findById(id);
		reservationRespository.delete(reservation.get());
		
		return "Reservation deleted";
	}
	
	
 	
	

}
