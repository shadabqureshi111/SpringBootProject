package com.p.PatientReport.controller;

import java.awt.PageAttributes.MediaType;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.p.PatientReport.Model.DiseaseDetail;
import com.p.PatientReport.Model.PatientDetail;
import com.p.PatientReport.Model.Prescription;
import com.p.PatientReport.repository.DiseaseRepository;
import com.p.PatientReport.repository.PrescriptionRepository;
import com.p.PatientReport.service.DiseaseServiceImpl;
import com.p.PatientReport.service.PatientServiceImpl;
import com.p.PatientReport.service.PrescriptionServiceImpl;

@org.springframework.stereotype.Controller
@RequestMapping("/form")
public class Controller 
{	
	@Autowired
	private PatientServiceImpl psi;
	@Autowired
	private DiseaseServiceImpl dsi;
	
	@Autowired
	private DiseaseRepository dr;
	
	@Autowired
	private PrescriptionServiceImpl presi;
	
	@RequestMapping(path = "/registration",method =RequestMethod.GET)
	public String getForm(Model model,HttpSession https)
	{
		List<DiseaseDetail> fetchDisease = dsi.FetchDisease();
		model.addAttribute("diseaseList", fetchDisease);
		return "patientRegister";
	}
	
	@RequestMapping(path = "/getDName",method =RequestMethod.GET)
	public String fetchDoctorName(@RequestParam("id") Long id)
	{
		DiseaseDetail findByDiseaseId = dr.findByDiseaseId(id);
		System.out.println(findByDiseaseId.getDoctor_name());
		return findByDiseaseId.getDoctor_name();
	}
	
	@RequestMapping(path = "/saveData",method = RequestMethod.POST)
	public String SavePatientData(@ModelAttribute PatientDetail pDetail,
								  @ModelAttribute Prescription prescription,
								  @RequestParam("fk_disease_id") Long d_id)
	{
		System.out.println(pDetail);
		DiseaseDetail dd = new DiseaseDetail();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		prescription.setFk_patient_id(pDetail);
		prescription.setDate_of_visit(date);
		dsi.SavePresData(dd);
		psi.SavePatientData(pDetail);
		presi.SavePrescriptionData(prescription);
		return "redirect:./registration";
	}

	@GetMapping(path ="/fetchDetail")
	public String FetchPatientData(Model model,HttpSession session)
	{
		List<DiseaseDetail> fetchPatientData = dsi.FetchPatientData();
		System.out.println(fetchPatientData);
		model.addAttribute("patientDetails",fetchPatientData);
		session.setMaxInactiveInterval(1);
		return "fetchData";
	}
	
//	@RequestMapping(path="/deleteDetail",method = RequestMethod.GET)
//	public String DeletePatientData(@RequestParam("id") Long id,Model model)
//	{
//		if(id!=null)
//		{
//		List<Prescription> fetchPatientData = presi.FetchPatientData();
//		presi.DeletePrescriptionData(id);
//		}
//		return "";
//	}
	
}

