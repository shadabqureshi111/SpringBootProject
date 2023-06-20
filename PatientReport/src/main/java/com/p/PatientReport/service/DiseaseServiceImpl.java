package com.p.PatientReport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p.PatientReport.Model.DiseaseDetail;
import com.p.PatientReport.Model.Prescription;
import com.p.PatientReport.repository.DiseaseRepository;

@Service
public class DiseaseServiceImpl implements DiseaseService
{
	@Autowired
	private DiseaseRepository dr;

	@Override
	public List<DiseaseDetail> FetchDisease() 
	{
		List<DiseaseDetail> diseaseList = dr.findAll();
		return diseaseList;
	}

	@Override
	public String SavePresData(DiseaseDetail dd) 
	{
		dr.save(dd);
		return null;
	}

	@Override
	public List<DiseaseDetail> FetchPatientData() 
	{
		List<DiseaseDetail> findAll = dr.findAll();
		
		return findAll;
	}
	
	
}
