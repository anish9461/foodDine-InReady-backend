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
@RequestMapping("/orders")
//this is the controller class for the orders API
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Orders add(@RequestBody Orders order) {
        return ordersRepository.save(order);
    }
    // retrieve the list of orders
    @GetMapping
    public List<Orders> getAll() {
        return ordersRepository.findAll();
    }
    // retrieve a single order with id
    @GetMapping(value = "/{id}")
    public Orders getOne(@PathVariable String id) {
        return ordersRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
    }
    // update the fields of order
    @PutMapping(value = "/{id}")
    public Orders update(@PathVariable String id, @RequestBody Orders updatedOrders) {
        Orders order = ordersRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
        order.setdatetime(updatedOrders.getdatetime());
        order.setparkingSlot(updatedOrders.getparkingSlot());
        order.setpreorder(updatedOrders.getpreorder());
        order.setrestaurantName(updatedOrders.getrestaurantName());
        order.setemail(updatedOrders.getemail());
        order.setTableName(updatedOrders.getTableName());
        
        return ordersRepository.save(order);
    }
    // delete an order
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@PathVariable String id) {
        Orders order = ordersRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException());
        ordersRepository.delete(order);
    }
    // get all the orders placed in a restaurant by its email.
    @GetMapping("/searchByEmail")
    public List<Orders> searchByEmail(@RequestParam(name = "email") String email) {
    	List<Orders> result = new ArrayList<>();
    	result = ordersRepository.findByEmail(email);
    	return result;
    }
    // get all the orders placed by a user by user email.
    @GetMapping("/searchByUserEmail")
    public List<Orders> searchByUserEmail(@RequestParam(name = "userEmail") String userEmail) {
    	List<Orders> result = new ArrayList<>();
    	result = ordersRepository.findByUserEmail(userEmail);
    	return result;
    }
    

      

    

}