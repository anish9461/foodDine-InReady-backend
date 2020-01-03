package com.mynotes.spring.data.mongodb;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;


// this interface gives the list of users with email / name given
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);
    List<User> findByfirstName(String firstName);


    

}
