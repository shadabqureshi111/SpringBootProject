package com.csm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.csm.model.Doctor_Appointment;
import com.csm.model.Doctor_Master;

@Repository
public interface PatientRepository extends JpaRepository<Doctor_Appointment, Integer> 
{
	List<Doctor_Appointment> findByDoctorId(Doctor_Master doctor);
	List<Doctor_Appointment> findByPatientName(String patientName);
	List<Doctor_Appointment> findByDoctorAppointmentId(Integer doctorAppointmentId);
	
	
	/* These are repository function,we can use it . */
	
//	List<Doctor_Appointment> findByPatientNameStartingWith(String Prefix);
//	List<Doctor_Appointment> findByPatientNameEndingWith(String Suffix);
//	List<Doctor_Appointment> findByPatientNameContaining(String word);
//	List<Doctor_Appointment> findByPatientNameLike(String Prefix);
//	List<Doctor_Appointment> findByPatientNameOrderByPatientName(String Prefix);
	
	
	
	
	
	/* Java Persistance Query Language (JPQL) */
	
//	@Query("select d FROM Doctor_Master d")
//	public List<Doctor_Master> getAllDoctor();
//	
//	@Query("select d FROM Doctor_Master d WHERE d.doctorName =:n")
//	public List<Doctor_Master> getDoctorByDoctorName(@Param("n") String name);
	
	
	
	
	/* Native Query */
	
	@Query(value="Select * from doctor_master",nativeQuery =true)
	public List<Doctor_Master> getAllDoctor();
	
	
	
	
	
	
}
