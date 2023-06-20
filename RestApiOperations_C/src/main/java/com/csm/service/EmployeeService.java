package com.csm.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.csm.exception.ResourceNotFoundException;
import com.csm.model.Employee;

public interface EmployeeService 
{
	public ResponseEntity<Employee> SaveEmployee(Employee employee);
	public ResponseEntity<Employee> UpdateEmployee(Long id, Employee employee) throws ResourceNotFoundException ;
	public ResponseEntity<Employee> DeleteEmployee(Long id) throws ResourceNotFoundException;
	public List<Employee> getAllEmployees() ;
	public ResponseEntity<Employee> getEmployeeById(Long id) throws ResourceNotFoundException;
	
	
	
	
	
}
