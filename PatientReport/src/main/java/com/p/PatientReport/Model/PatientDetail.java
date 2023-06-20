package com.p.PatientReport.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
public class PatientDetail 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patient_id;
	private String firstName;
	private String lastName;
	private String gender;
	private String age;
	private String number;
	private String address;
	private String city;
	private String state;
	private String pincode;
	private String fatherName;
	private String spouseName;

}
