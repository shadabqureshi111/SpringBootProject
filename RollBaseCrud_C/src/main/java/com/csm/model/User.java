package com.csm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "USER")
public class User {
    @Id
    private String username;
    
    private String password;
    
    private String role;
    
    // Getters and setters
}
