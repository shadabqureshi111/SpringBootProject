package com.csm.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;




@Entity
@Data
public class Payslip {
	//private Long id;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emp_id;	
	private String name;
	private Double basicSalary;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = SalaryDetail.class)
	@JoinColumn(name = "salary_id")
	public SalaryDetail salry_detail_id;
	
	
}
