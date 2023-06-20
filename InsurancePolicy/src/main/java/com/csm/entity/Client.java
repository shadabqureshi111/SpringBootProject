package com.csm.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Client implements Serializable
{   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Name is mandatory")
    private String name;
    
    @NotNull(message = "Date of birth is mandatory")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    
    @NotBlank(message = "Address is mandatory")
    private String address;
    
    @NotBlank(message = "Contact information is mandatory")
    private String contactInformation;
    
    @OneToMany(mappedBy = "client")
    private List<InsurancePolicy> insurancePolicies = new ArrayList<>();
    
}
