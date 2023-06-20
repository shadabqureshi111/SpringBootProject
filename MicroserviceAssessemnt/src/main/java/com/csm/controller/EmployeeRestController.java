package com.csm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.csm.model.Employee;

//public class EmployeeRestController 
//{
//	  private static final String BASE_URL = "http://localhost:8080/employees";
//	  private final RestTemplate r;
//	public static void main(String[] args) {
//	    RestTemplate restTemplate = new RestTemplate();
//
//	    // Fetch employees
//	    ResponseEntity<Employee[]> responseEntity = restTemplate.getForEntity(BASE_URL, Employee[].class);
//	    Employee[] employees = responseEntity.getBody();
//	    for (Employee employee : employees) {
//	        System.out.println(employee);
//	    }
//
//	    // Fetch Employee By Id
//	    Long employeeId = 1L;
//	    Employee employee = restTemplate.getForObject(BASE_URL + "/" + employeeId, Employee.class);
//	    System.out.println(employee);
//
//	    // Add New Employee
//	    Employee newEmployee = new Employee();
//	    newEmployee.setEmpName("Shadab");
//	    newEmployee.setEmpEmail("s@gmail.com");
//	    newEmployee.setEmpPhone("1111111111");
//	    newEmployee.setEmpAddress("Jaipur");
//
//	    Employee createdEmployee = restTemplate.postForObject(BASE_URL, newEmployee, Employee.class);
//	    System.out.println(createdEmployee);
//
//	    // Update employee
//	    Employee updatedEmployee = restTemplate.getForObject(BASE_URL + "/" + employeeId, Employee.class);
//	    updatedEmployee.setEmpName("Shadab Qureshi");
//	    updatedEmployee.setEmpEmail("shadab@gmail.com");
//	    updatedEmployee.setEmpPhone("1234567890");
//	    updatedEmployee.setEmpAddress("Gwalior");
//
//	    restTemplate.put(BASE_URL + "/" + employeeId, updatedEmployee);
//
//	    // Delete employee
//	    restTemplate.delete(BASE_URL + "/" + employeeId);
//	}
//
//}

public class EmployeeRestController {

    private static final String BASE_URL = "http://localhost:8082/employees";

    private RestTemplate restTemplate = new RestTemplate();

     EmployeeRestController() 
     {
        this.restTemplate = new RestTemplate();
    }

    public Employee createEmployee(Employee employee) {
        return restTemplate.postForObject(BASE_URL+"/save", employee, Employee.class);
    }

    public Employee getEmployeeById(Long id) {
    	   String url = BASE_URL + "/" + id;
           return restTemplate.getForObject(url, Employee.class);
    }

    public void updateEmployee(Long id, Employee updatedEmployee) {
        String url = BASE_URL + "/" + id;
        restTemplate.put(url, updatedEmployee);
    }

    public void deleteEmployee(Long id) {
        String url = BASE_URL + "/" + id;
        restTemplate.delete(url);
    }

    public static void main(String[] args) {
       EmployeeRestController employeeRestController = new EmployeeRestController();

        // Create an employee
        Employee newEmployee = new Employee();
        newEmployee.setEmpName("Shadab");
        newEmployee.setEmpEmail("s@gmail.com");
        newEmployee.setEmpPhone("1234567890");
        newEmployee.setEmpAddress("jaipur");
        employeeRestController.createEmployee(newEmployee);
        System.out.println("Add Employee: " + newEmployee);

        // Get an employee by ID
        Long employeeId = newEmployee.getEmpId();
        Employee retrievedEmployee = employeeRestController.getEmployeeById(3L);
        System.out.println("Employee Get: " + retrievedEmployee);

        // Update the employee
        newEmployee.setEmpName("Shadab Qureshi");
        employeeRestController.updateEmployee(3L, retrievedEmployee);
        System.out.println("Update Employee: " + retrievedEmployee);

        // Delete the employee
        employeeRestController.deleteEmployee(3L);
        System.out.println("Employee deleted.");
    }
}
