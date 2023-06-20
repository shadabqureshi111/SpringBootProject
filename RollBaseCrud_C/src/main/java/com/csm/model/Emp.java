package com.csm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Emp 
{
	@Id
	private Long id;
	@Column(name = "firstname")
	private String fname;
	@Column(name = "lastname")
	private String lname;
	@Column(name = "salary")
	private Double salary;

}
