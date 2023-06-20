package com.csm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "salaryDetail")
public class SalaryDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer month;
	private Integer year;
	private Double hra;
	private Double da;
	private Double ta;
	private Double pf;
	private Double net_salary;
	
	
}
