package com.mynotes.spring.data.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
// setting the values for the tables.
@Document(collection = "tables")
public class Tables {

    @Id
    private String id;
    
    private String tableX;
    
    private String tableY;
    
    private String tablename;
    
    private String [] datetime; 
    
   
//    @Indexed(unique = true)
    private String email;
// setting getters and setters for the tables
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
  
    public String getemail() {
        return email;
    }

    public void settableX(String tableX) {
        this.tableX = tableX;
    }
    
    public String gettableX() {
        return tableX;
    }
    
    public void settableY(String tableY) {
        this.tableY = tableY;
    }
    
    public String gettableY() {
        return tableY;
    }

    public void setemail(String email) {
        this.email = email;
    }
    
    
    public String getTableName() {
        return tablename;
    }

    public void setTableName(String tablename) {
        this.tablename = tablename;
    }
    
    public String[] getdatetime() {
        return datetime;
    }

    public void setdatetime(String[] datetime) {
        this.datetime = datetime;
    }

}