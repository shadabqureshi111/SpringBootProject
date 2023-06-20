package com.p.PatientReport.service;

import org.springframework.stereotype.Service;

import com.p.PatientReport.Model.DiseaseDetail;
import com.p.PatientReport.Model.PatientDetail;
import com.p.PatientReport.Model.Prescription;

public interface PatientReportService 
{
	String SavePatientData(PatientDetail p);
}
