package com.csm.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Prescription 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer slno;
	
	@Column(name ="prescription" )
	private String prescriptions_detail;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_appoiintment_id")
	private Doctor_Appointment doctorAppointmentId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "disease_id")
	private Disease_Master diseaseId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medicine_id")
	private Medicine_Master medicineId;

	

}
