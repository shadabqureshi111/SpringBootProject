package com.csm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class InsurancePolicy implements Serializable
{
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotBlank(message = "Policy number is mandatory")
	    private String policyNumber;
	    
	    @NotBlank(message = "Type is mandatory")
	    private String type;
	    
	    @NotNull(message = "Coverage amount is mandatory")
	    @Positive(message = "Coverage amount must be positive")
	    private BigDecimal coverageAmount;
	    
	    @NotNull(message = "Premium is mandatory")
	    @Positive(message = "Premium must be positive")
	    private BigDecimal premium;
	    
	    @NotNull(message = "Start date is mandatory")
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private LocalDate startDate;
	    
	    @NotNull(message = "End date is mandatory")
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private LocalDate endDate;
	    
	    @ManyToOne
	    @JoinColumn(name = "client_id")
	    private Client client;
	    
	    @OneToMany(mappedBy = "insurancePolicy")
	    private List<Claim> claims = new ArrayList<>();
	    
	    // getters and setters
}

