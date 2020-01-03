package com.mynotes.spring.data.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
// setting all the required fields.
@Document(collection = "admin")
public class Admin {

    @Id
   
    private String id;
    
    private String name;
    
    private String contactInfo;
    
    
    private String resAddress; 
    
    private String resTiming; 
    
    @Indexed(unique = true)
    private String email;
    //setting getters and setters for the fields.
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