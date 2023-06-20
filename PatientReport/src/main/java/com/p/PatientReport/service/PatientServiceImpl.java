package com.p.PatientReport.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p.PatientReport.Model.DiseaseDetail;
import com.p.PatientReport.Model.PatientDetail;
import com.p.PatientReport.Model.Prescription;
import com.p.PatientReport.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientReportService
{
	@Autowired
	private PatientRepository prepo;

	@Override
	public String SavePatientData(PatientDetail p) 
	{
		if(p!=null)
		{
		prepo.save(p);
		return "submit";
		}
		return "Retry";

	}

}
