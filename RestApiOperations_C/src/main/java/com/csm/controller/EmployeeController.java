package com.csm.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.csm.exception.ResourceNotFoundException;
import com.csm.model.Employee;
import com.csm.service.EmployeeServiceImpl;


@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl employeeService;

	@PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> SaveEmployee(@Valid @RequestBody Employee employee) 
	{
		System.out.println(employee);
		ResponseEntity<Employee> saveEmployee = employeeService.SaveEmployee(employee);
		return saveEmployee;
	}

	@PostMapping(path = "/getAll")
	public List<Employee> getAllEmployees() 
	{
		return employeeService.getAllEmployees();
	}

	@GetMapping("getbyid/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws ResourceNotFoundException 
	{
		ResponseEntity<Employee> employeeById = employeeService.getEmployeeById(id);
		return employeeById;
	}

	@PutMapping("update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) throws ResourceNotFoundException 
	{
		ResponseEntity<Employee> updateEmployee = employeeService.UpdateEmployee(id, employee);
		return updateEmployee;
	}

	@DeleteMapping("delete/{id}")
	public String deleteEmployee(@PathVariable Long id) throws ResourceNotFoundException 
	{
		ResponseEntity<Employee> deleteEmployee = employeeService.DeleteEmployee(id);
		if(deleteEmployee!=null)
		{
			return "Delete Succesfully";
		}
		else
		{
			return "Something Error";
		}
		
	}
}