package com.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csm.model.Disease_Master;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease_Master, Integer> {

}
