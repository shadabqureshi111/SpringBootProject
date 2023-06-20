package com.csm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Disease_Master 
	{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer disease_id;
		private String disease_Name;
	}
