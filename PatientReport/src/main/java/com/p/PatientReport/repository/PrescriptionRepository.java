package com.p.PatientReport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.p.PatientReport.Model.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

}
