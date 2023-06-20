package com.p.PatientReport.service;

import java.util.List;

import com.p.PatientReport.Model.DiseaseDetail;
import com.p.PatientReport.Model.Prescription;

public interface DiseaseService 
{
	public List<DiseaseDetail> FetchDisease();
	public String SavePresData(DiseaseDetail dd);
	public List<DiseaseDetail> FetchPatientData();
}
