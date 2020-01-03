package com.mynotes.spring.data.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("/user")
// controller class for the user api
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public User add(@RequestBody User user) {
        return userRepository.save(user);
    }
    // gives a list of all users
    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }
    // gives one user by id
    @GetMapping(value = "/{id}")
    public User getOne(@PathVariable String id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
    }
    // updates the value of fields of the user api
    @PutMapping(value = "/{id}")
    public User update(@PathVariable String id, @RequestBody User updatedUser) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        return userRepository.save(user);
    }
    // used to delete a user
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@PathVariable String id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
        userRepository.delete(user);
    }
    //search a user by email.
    @GetMapping("/searchByEmail")
    public User searchByEmail(@RequestParam(name = "email") String email) {
        return userRepository.findByEmail(email)
            .orElseThrow(() -> new ResourceNotFoundException());

    }
    

    // search a user by user name
    @GetMapping("/searchByName")
    public List<User> searchByName(@RequestParam(name = "firstName") String firstName) {
        List<User> result = new ArrayList<>();
        
        result = userRepository.findByfirstName(firstName);
        
        return result;
    }
    
    
    


    

}
