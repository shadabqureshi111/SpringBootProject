package com.p.PatientReport.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
public class Prescription 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long prescription_id;
	
	private String date_of_visit;
	
	private String prescription_detail;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = PatientDetail.class)
	@JoinColumn(name = "fk_patient_id")
	public PatientDetail fk_patient_id;
	
//	@ManyToOne
//	private DiseaseDetail fk_disease_id;

}
