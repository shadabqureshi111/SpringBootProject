package com.csm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csm.model.Disease_Master;
import com.csm.model.Doctor_Appointment;
import com.csm.model.Doctor_Master;
import com.csm.model.Medicine_Master;
import com.csm.model.Prescription;
import com.csm.repository.DiseaseRepository;
import com.csm.repository.DoctorRepository;
import com.csm.repository.MedicineRepository;
import com.csm.repository.PatientRepository;
import com.csm.repository.PrescriptionRepository;


@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
	@Autowired
	private DiseaseRepository ds;
	@Autowired
	private DoctorRepository dr;
	@Autowired
	private MedicineRepository mr;
	@Autowired
	private PatientRepository pr;
	@Autowired
	private PrescriptionRepository prescriptionRepository;

	@GetMapping("/")
	public String getForm(Model model) 
		{
			List<Disease_Master> diseaseList = ds.findAll();
			List<Doctor_Master> doctorList = dr.findAll();
			List<Medicine_Master> MedicineList = mr.findAll();
			List<Doctor_Appointment> patientList = pr.findAll();
			List<Prescription> prescriptionData = prescriptionRepository.findAll();
			model.addAttribute("diseaseList", diseaseList);
			model.addAttribute("doctorList", doctorList);
			model.addAttribute("MedicineList", MedicineList);
			model.addAttribute("pData", prescriptionData);
			
			// model.addAttribute("patientList", patientList);
			
			
			return "Batch";
		}

//	@RequestMapping(value = "/getPatientList", method = RequestMethod.GET)
//	@ResponseBody
//	public List<Map<String, Object>> getPatientList(
//			@RequestParam(value = "doctorValue", required = false, defaultValue = "") Integer doctor_id,
//			@RequestParam(value = "pName", required = false, defaultValue = "") String patientName) 
//		{
//		System.out.println("doctorId = "+doctorId);
//			List<Doctor_Appointment> patientList = null;
//			
//			if (!patientName.equals("")) 
//				{
//					// If a patient name is provided, search by patient name
//					patientList = pr.findByPatientName(patientName);
//				} 
//			else 
//				{
//					// Otherwise, search by doctor ID
//				 Doctor_Master doctor = new Doctor_Master();
//			        doctor.setDoctor_id(doctor_id);
//			        patientList = pr.findByDoctorId(doctor);
//				}
//	
//			List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
//			for (Doctor_Appointment patient : patientList) 
//				{
//					Map<String, Object> map = new HashMap<String, Object>();
//					
//					map.put("patientId", patient.getDoctorAppointmentId());
//					map.put("patientName", patient.getPatientName());
//		
//					map.put("date", patient.getDate_Of_appointment());
//					map.put("phone", patient.getPatient_Phone());
//		
//					result.add(map);
//				}
//	
//			return result;
//		}

	@GetMapping("/getPatientList")
	@ResponseBody
	public List<Map<String, Object>> getPatientList(
			@RequestParam(value = "doctorValue", required = false, defaultValue = "") Integer doctorId,
			@RequestParam(value = "pName", required = false, defaultValue = "") String patientName) {

		List<Doctor_Appointment> patientList = null;

		if (!patientName.equals("")) {
			// If a patient name is provided, search by patient name
			patientList = pr.findByPatientName(patientName);
		} else {
			// Otherwise, search by doctor ID
			Doctor_Master doctor = new Doctor_Master();
			doctor.setDoctor_id(doctorId);
			patientList = pr.findByDoctorId(doctor);
		}

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (Doctor_Appointment patient : patientList) {
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("patientId", patient.getDoctorAppointmentId());
			map.put("patientName", patient.getPatientName());

			map.put("date", patient.getDate_Of_appointment());
			map.put("phone", patient.getPatient_Phone());

			result.add(map);
		}

		return result;
	}

	@RequestMapping(value = "/getMedicineList", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getMedicineList(
			@RequestParam(value = "diseaseId", required = false, defaultValue = "") Integer diseaseId) {
		Disease_Master disease = new Disease_Master();
		disease.setDisease_id(diseaseId); // set the diseaseId parameter to the Disease_Master object

		List<Medicine_Master> medicineList = mr.findByDiseaseId(disease);
		List<Map<String, Object>> result = new ArrayList<>();

		for (Medicine_Master medicine : medicineList) {
			Map<String, Object> map = new HashMap<>();
			map.put("medicineId", medicine.getMedicine_id());
			map.put("medicineName", medicine.getMedicine_Name());
			result.add(map);
		}
		return result;
	}

	@PostMapping("/saveData")
	public String dataSave(@ModelAttribute Prescription prescription, BindingResult result) 
	{
			
		
		if (result.hasErrors()) 
			{
				return "error";
			}
		
		// Update Doctor_Appointment status to 'P'
		Integer doctorAppointmentId = prescription.getDoctorAppointmentId().getDoctorAppointmentId();
		Doctor_Appointment patientDetail = pr.findById(doctorAppointmentId).orElseThrow();
		patientDetail.setPatient_Status('P');
		pr.save(patientDetail);
		
		// Save Prescription Data
		prescriptionRepository.save(prescription);
		return "redirect:/";
	}

}
