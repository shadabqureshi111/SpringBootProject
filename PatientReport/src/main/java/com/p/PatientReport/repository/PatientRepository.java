package com.p.PatientReport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.p.PatientReport.Model.PatientDetail;

@Repository
public interface PatientRepository extends JpaRepository<PatientDetail,Long>
{
}
