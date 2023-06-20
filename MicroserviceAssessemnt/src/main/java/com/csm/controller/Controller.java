package com.csm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csm.model.Employee;
import com.csm.repository.EmpRepository;

@RestController
@RequestMapping("/employees")
public class Controller {
    @Autowired
    private EmpRepository employeeRepository;

    @GetMapping("/getall")
    public List<Employee> getAllEmployees() 
    {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) 
    {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    @PostMapping("/save")
    public Employee createEmployee(@RequestBody Employee employee) 
    {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) 
    {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        employee.setEmpName(updatedEmployee.getEmpName());
        employee.setEmpEmail(updatedEmployee.getEmpEmail());
        employee.setEmpPhone(updatedEmployee.getEmpPhone());
        employee.setEmpAddress(updatedEmployee.getEmpAddress());

        return employeeRepository.save(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}