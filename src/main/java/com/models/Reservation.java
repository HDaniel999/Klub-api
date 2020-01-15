package com.models;

import org.springframework.data.annotation.Id;

public class Reservation {
	
	@Id
	private String id;
	private String userId;
	private String restaurantId;
	private String reservationDate;
	private String reservationHour;
	private String numberOfPeople;
	private boolean isCanceled;
	
	public boolean getIsCanceled() {
		return isCanceled;
	}
	
	public void setIsCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	public String getRestaurantId() {
		return restaurantId;
	}
	
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	
	
	public String getReservationDate() {
		return reservationDate;
	}
	
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	
	
	
	public String getReservationHour() {
		return reservationHour;
	}
	
	public void setReservationHour(String reservationHour) {
		this.reservationHour = reservationHour;
	}
	
	
	
	public String getNumberOfPeople() {
		return numberOfPeople;
	}
	
	public void setNumberOfPeople(String numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

}
