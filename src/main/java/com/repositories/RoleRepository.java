package com.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

	Role findByRole(String role);
	
}
