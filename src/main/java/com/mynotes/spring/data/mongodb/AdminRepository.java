package com.mynotes.spring.data.mongodb;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface AdminRepository extends MongoRepository<Admin, String> {
	Optional<Admin> findByEmail(String email);
	
    //List<Restaurant> findByname(String name);
}
