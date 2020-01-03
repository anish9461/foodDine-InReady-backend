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


@CrossOrigin
@RestController
@RequestMapping("/admin")
// this is the controller for the admin api
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Admin add(@RequestBody Admin admin) {
        return adminRepository.save(admin);
    }
    // gives a list of all the admins - current scenario is single admin
    @GetMapping
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }
    // in case of multiple admins, this can be used to retireve info of a single admin with id
    @GetMapping(value = "/{id}")
    public Admin getOne(@PathVariable String id) {
        return adminRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
    }
    // the following updates the details of the admin.
    @PutMapping(value = "/{id}")
    public Admin update(@PathVariable String id, @RequestBody Admin updatedAdmin) {
        Admin admin = adminRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
        admin.setName(updatedAdmin.getName());
        admin.setContact(updatedAdmin.getContact());
        admin.setEmail(updatedAdmin.getEmail());
        admin.setresAddress(updatedAdmin.getresAddress());
        admin.setresTiming(updatedAdmin.getresTiming());
        return adminRepository.save(admin);
    }
    // in case of multiple admins, one admin can be deleted using the following method.
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@PathVariable String id) {
        Admin admin = adminRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
        adminRepository.delete(admin);
    }
    //in case of multiple admins, admin can be looked by by using the following function and providing the email
    @GetMapping("/searchByEmail")
    public Admin searchByEmail(@RequestParam(name = "email") String email) {
        return adminRepository.findByEmail(email)
            .orElseThrow(() -> new ResourceNotFoundException());

    }
    
    

    

      

    

}
