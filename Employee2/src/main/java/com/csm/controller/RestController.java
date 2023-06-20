package com.csm.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.csm.model.Employee;


public class RestController 
{

    public static void main(String[] args) 
    {
    	 RestTemplate restTemplate = new RestTemplate();

         Long employeeId = 1L; 

         String url = "http://localhost:8080/employees/" + employeeId;
         ResponseEntity<Employee> response = restTemplate.exchange(url, HttpMethod.GET, null, Employee.class);

         Employee employee = response.getBody();

         System.out.println("Employee ID: " + employee.getId());
         System.out.println("Employee Name: " + employee.getName());
         System.out.println("Employee Salary: " + employee.getSalary());
     
    }
}