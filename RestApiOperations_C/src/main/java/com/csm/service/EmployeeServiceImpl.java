package com.csm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.csm.exception.ResourceNotFoundException;
import com.csm.model.Employee;
import com.csm.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public ResponseEntity<Employee> SaveEmployee(Employee employee) 
	{
		Employee save = employeeRepository.save(employee);
		return new ResponseEntity<>(save, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Employee> DeleteEmployee(Long id) throws ResourceNotFoundException {
		try {
			Employee deleteEmp = employeeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

			employeeRepository.deleteById(id);
			return ResponseEntity.ok().body(deleteEmp);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException("Employee table not found with id: " + id);
		}
	}

	@Override
	public ResponseEntity<Employee> getEmployeeById(Long id) throws ResourceNotFoundException {
		Employee getById = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id = " + id));
		return ResponseEntity.ok().body(getById);
	}

	@Override
	public List<Employee> getAllEmployees() {
		try 
			{
				List<Employee> findAll = employeeRepository.findAll();
				return findAll;
			} 
		catch (EmptyResultDataAccessException ex) 
			{
				System.err.println("No employees found in the database.");
				return new ArrayList<Employee>();
			}
	}

	public ResponseEntity<Employee> UpdateEmployee(Long id, Employee employee) throws ResourceNotFoundException 
	{
		Employee existingEmployee = employeeRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id = " + id));

		if (existingEmployee == null) 
			{
				return ResponseEntity.notFound().build();
			}
		
		existingEmployee.setEmpName(employee.getEmpName());
		existingEmployee.setEmpSalary(employee.getEmpSalary());
		existingEmployee.setEmpMob(employee.getEmpMob());

		Employee updatedEmployee = employeeRepository.save(existingEmployee);

		return ResponseEntity.ok().body(updatedEmployee);	
	}

}
