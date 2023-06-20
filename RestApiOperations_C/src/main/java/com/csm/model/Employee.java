package com.csm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class Employee implements Serializable
	{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long empId;
	
		@NotEmpty
		@Size(min = 3, message = "name may not be empty or less than 3")
		private String empName;
		
		@Positive(message = "salary should be greater than 0")
		private Double empSalary;
		
		@NotEmpty
		@Size(min = 10, max = 10, message = "number should be 10 digit")
		private String empMob;
	
	}
