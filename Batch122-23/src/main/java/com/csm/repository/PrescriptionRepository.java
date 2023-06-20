package com.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csm.model.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription,Integer>
{

}
