package com.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csm.model.Emp;

public interface EmpRepository extends JpaRepository<Emp,Long> 
{

}
