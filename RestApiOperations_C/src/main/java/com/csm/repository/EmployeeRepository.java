package com.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csm.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> 
{

}