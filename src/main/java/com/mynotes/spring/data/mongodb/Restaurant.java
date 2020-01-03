package com.mynotes.spring.data.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurant")
public class Restaurant {
// fields for restaurant api
    @Id
    private String id;
    
    
    private String name;
    
    private String contactInfo;
    
    private String locationX;
    
    private String locationY;
    
    private String resAddress; 
    
    private String resTiming; 
    
    @Indexed(unique = true)
    private String email;
    // setting the getters and setters for restaurant api 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getContact() {
    	return contactInfo;
    }
    public void setContact(String contactInfo) {
    	this.contactInfo = contactInfo;
    }
    
    public String getLocationX() {
    	return locationX;
    }
    public void setLocationX(String locationX) {
    	this.locationX = locationX;
    }
    public String getLocationY() {
    	return locationY;
    }
    public void setLocationY(String locationY) {
    	this.locationY = locationY;
    }
    
    public String getresAddress() {
    	return resAddress;
    }
    public void setresAddress(String resAddress) {
    	this.resAddress = resAddress;
    }
   
    public void setresTiming(String resTiming) {
    	this.resTiming = resTiming;
    }

	public String getresTiming() {
		return resTiming;
	}
    
   

}