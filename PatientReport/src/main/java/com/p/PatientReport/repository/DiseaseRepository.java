package com.p.PatientReport.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.p.PatientReport.Model.DiseaseDetail;
import com.p.PatientReport.Model.Prescription;

@Repository
public interface DiseaseRepository extends JpaRepository<DiseaseDetail,Long>
{
	DiseaseDetail findByDiseaseId(Long diseaseId);

//	@Transactional
//	@Modifying
//    @Query("UPDATE DiseaseDetail SET fk_patient_id = :prescription WHERE disease_id = :d_id")
//    int updatePatientData(@Param("prescription") Prescription prescription,@Param("d_id") Long d_id);
	
}
