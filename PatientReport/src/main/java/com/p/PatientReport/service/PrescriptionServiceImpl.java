package com.p.PatientReport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p.PatientReport.Model.Prescription;
import com.p.PatientReport.repository.PrescriptionRepository;

@Service
public class PrescriptionServiceImpl implements PrescriptionService
{

	@Autowired
	private PrescriptionRepository pr;
	
	@Override
	public String SavePrescriptionData(Prescription prescription) 
	{
		if(prescription!=null)
		{
		pr.save(prescription);
		return "submit";
		}
		return "retry";
	}

//	@Override
//	public List<Prescription> FetchPatientData() 
//	{
//		List<Prescription> findAllDetail = pr.findAll();
//		return findAllDetail;
//	}

	@Override
	public String DeletePrescriptionData(Long id) 
	{
		if(id!=null)
		{
		pr.deleteById(id);
		return "delete";
		}
		return "Try Again";
	}
	

}
