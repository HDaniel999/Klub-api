package com.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurantCategories")
public class RestaurantCategories {
	@Id
    private String id;
	
	@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)

    private String category;

}
