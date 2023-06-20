package com.csm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String secondName;
    private String work;
    @Column(unique = true)
    private String email;
    private String phone;
    private String image;
    @Column(length = 5000)
    private String description;
    
    @ManyToOne
    private User user;
    
    // Constructors, getters, and setters
}
