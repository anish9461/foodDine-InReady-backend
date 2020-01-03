package com.mynotes.spring.data.mongodb;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;


// gives the list of available tables in a restaurant
public interface TablesRepository extends MongoRepository<Tables, String> {

    List<Tables> findByEmail(String email);
  

}
