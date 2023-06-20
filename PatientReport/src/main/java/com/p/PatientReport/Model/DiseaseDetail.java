package com.p.PatientReport.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
public class DiseaseDetail 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long diseaseId;
	private String diseaseName;
	private String doctor_name;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Prescription.class)
	@JoinColumn(name = "fk_patient_id")
	public Prescription fk_patient_id;

    
	
	
	
}
