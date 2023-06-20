package com.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csm.model.Doctor_Master;

public interface DoctorRepository extends JpaRepository<Doctor_Master, Integer> {

}

