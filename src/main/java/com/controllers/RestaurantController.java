package com.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.models.Restaurant;
import com.repositories.RestaurantRepository;


@RestController
@CrossOrigin(
origins = "*", 
allowedHeaders = "*", 
methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class RestaurantController {
	
	@Autowired
    RestaurantRepository productRepository;

    @RequestMapping(method=RequestMethod.GET, value="/api/restaurants")
    public Iterable<Restaurant> product() {
        return productRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/api/restaurants")
    public String save(@RequestBody Restaurant product) {
        productRepository.save(product);

        return product.getId();
    }

    @RequestMapping(method=RequestMethod.GET, value="/api/restaurants/{id}")
    public Optional<Restaurant> show(@PathVariable String id) {
        return productRepository.findById(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/api/restaurants/{id}")
    public Restaurant update(@PathVariable String id, @RequestBody Restaurant product) {
        Optional<Restaurant> prod = productRepository.findById(id);
        if(product.getRestaurantName() != null)
            prod.get().setRestaurantName(product.getRestaurantName());
        if(product.getRestaurantAddress() != null)
            prod.get().setRestaurantAddress(product.getRestaurantAddress());
        if(product.getRestaurantPhone() != null)
            prod.get().setRestaurantPhone(product.getRestaurantPhone());
        if(product.getRestaurantWebPage() != null)
            prod.get().setRestaurantWebPage(product.getRestaurantWebPage());
        if(product.getRestaurantRaiting() != null)
            prod.get().setRestaurantRaiting(product.getRestaurantRaiting());
        if(product.getRestaurantLocation() != null)
            prod.get().setRestaurantLocation(product.getRestaurantLocation());
        if(product.getRestaurantMainCategory() != null)
            prod.get().setRestaurantMainCategory(product.getRestaurantMainCategory());
        if(product.getRestaurantSchedule() != null)
            prod.get().setRestaurantWebPage(product.getRestaurantSchedule());
        if(product.getRestaurantMainImage() != null)
            prod.get().setRestaurantMainImage(product.getRestaurantMainImage());
        if(product.getRestaurantCategories() != null)
            prod.get().setRestaurantCategories(product.getRestaurantCategories());
        productRepository.save(prod.get());
        return prod.get();
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/api/restaurants/{id}")
    public String delete(@PathVariable String id) {
        Optional<Restaurant> product = productRepository.findById(id);
        productRepository.delete(product.get());

        return "product deleted";
    }

}
