package com.p.PatientReport.service;

import java.util.List;

import com.p.PatientReport.Model.PatientDetail;
import com.p.PatientReport.Model.Prescription;

public interface PrescriptionService 
{
	public String SavePrescriptionData(Prescription prescription);
//	public List<Prescription> FetchPatientData();
	public String DeletePrescriptionData(Long id);
}
