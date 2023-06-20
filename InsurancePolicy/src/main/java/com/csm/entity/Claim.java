package com.csm.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Claim implements Serializable
{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotBlank(message = "Claim number is mandatory")
	    private String claimNumber;
	    
	    @NotBlank(message = "Description is mandatory")
	    private String description;
	    
	    @NotNull(message = "Claim date is mandatory")
	    private LocalDate claimDate;
	    
	    @NotBlank(message = "Claim status is mandatory")
	    private String claimStatus;
	    
	    @ManyToOne
	    @JoinColumn(name = "insurance_policy_id")
	    private InsurancePolicy insurancePolicy;
	    
}