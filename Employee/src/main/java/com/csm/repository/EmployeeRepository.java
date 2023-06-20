package com.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csm.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> 
{
	
}
