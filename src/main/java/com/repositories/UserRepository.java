package com.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.models.User;

@CrossOrigin(
origins = "*", 
allowedHeaders = "*", 
methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public interface UserRepository extends MongoRepository<User, String> {
	User findByEmail(String email);
	User findByMyFriendCode(String MyFriendCode);
}
