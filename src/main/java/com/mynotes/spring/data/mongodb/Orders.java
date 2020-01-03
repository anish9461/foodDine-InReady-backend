// this file contains the details for the orders.
package com.mynotes.spring.data.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Orders {
// private fields for the order API
    @Id
    private String id;
    
    private String datetime;
    
    private String parkingSlot;
    
    private String restaurantName;
    
    private String tableName;
    
    private String [] preorder; 
    // for retrieving orders based on user email.
    private String userEmail;
    
   
    // for retrieving orders based on restaurant email
    private String email;
    // setting getters and setters for the fields.
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    public String getdatetime() {
        return datetime;
    }

    public void setdatetime(String datetime) {
        this.datetime = datetime;
    }

   
    public String getparkingSlot() {
        return parkingSlot;
    }

    public void setparkingSlot(String parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
    
    public String getuserEmail() {
        return userEmail;
    }

    public void setuserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
    public String getrestaurantName() {
        return restaurantName;
    }

    public void setrestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
    
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
    public String[] getpreorder() {
        return preorder;
    }

    public void setpreorder(String[] preorder) {
        this.preorder = preorder;
    }

}
