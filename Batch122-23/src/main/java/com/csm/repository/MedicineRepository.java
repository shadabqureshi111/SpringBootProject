package com.csm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csm.model.Disease_Master;
import com.csm.model.Medicine_Master;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine_Master, Integer> 
{
    List<Medicine_Master> findByDiseaseId(Disease_Master disease);
}
