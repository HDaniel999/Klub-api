package com.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurants")
public class Restaurant {
	
	@Id
	String id;
	String restaurantName;
	String restaurantAddress;
	String restaurantPhone;
	String restaurantWebPage;
	String restaurantRaiting;
	String restaurantLocation;
	String restaurantMainCategory;
	String restaurantSchedule;
	String restaurantMainImage;
	@DBRef
	private List <RestaurantCategories> restaurantCategories;
	
	
	public Restaurant() {
	}

	public Restaurant(String id, String restaurantName, String restaurantAddress, String restaurantPhone,
			String restaurantWebPage, String restaurantRaiting, String restaurantLocation,
			String restaurantMainCategory, String restaurantSchedule, String restaurantMainImage,
			List<RestaurantCategories> restaurantCategories) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.restaurantPhone = restaurantPhone;
		this.restaurantWebPage = restaurantWebPage;
		this.restaurantRaiting = restaurantRaiting;
		this.restaurantLocation = restaurantLocation;
		this.restaurantMainCategory = restaurantMainCategory;
		this.restaurantSchedule = restaurantSchedule;
		this.restaurantMainImage = restaurantMainImage;
		this.restaurantCategories = restaurantCategories;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

	public String getRestaurantPhone() {
		return restaurantPhone;
	}

	public void setRestaurantPhone(String restaurantPhone) {
		this.restaurantPhone = restaurantPhone;
	}

	public String getRestaurantWebPage() {
		return restaurantWebPage;
	}

	public void setRestaurantWebPage(String restaurantWebPage) {
		this.restaurantWebPage = restaurantWebPage;
	}

	public String getRestaurantRaiting() {
		return restaurantRaiting;
	}

	public void setRestaurantRaiting(String restaurantRaiting) {
		this.restaurantRaiting = restaurantRaiting;
	}

	public String getRestaurantLocation() {
		return restaurantLocation;
	}

	public void setRestaurantLocation(String restaurantLocation) {
		this.restaurantLocation = restaurantLocation;
	}

	public String getRestaurantMainCategory() {
		return restaurantMainCategory;
	}

	public void setRestaurantMainCategory(String restaurantMainCategory) {
		this.restaurantMainCategory = restaurantMainCategory;
	}

	public String getRestaurantSchedule() {
		return restaurantSchedule;
	}

	public void setRestaurantSchedule(String restaurantSchedule) {
		this.restaurantSchedule = restaurantSchedule;
	}

	public String getRestaurantMainImage() {
		return restaurantMainImage;
	}

	public void setRestaurantMainImage(String restaurantMainImage) {
		this.restaurantMainImage = restaurantMainImage;
	}

	public List<RestaurantCategories> getRestaurantCategories() {
		return restaurantCategories;
	}

	public void setRestaurantCategories(List<RestaurantCategories> restaurantCategories) {
		this.restaurantCategories = restaurantCategories;
	}

	

}
