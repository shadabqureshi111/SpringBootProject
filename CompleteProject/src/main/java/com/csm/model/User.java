package com.csm.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String age;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dob;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deptId")
//    @JsonManagedReference
    private Dept deptId;

}
