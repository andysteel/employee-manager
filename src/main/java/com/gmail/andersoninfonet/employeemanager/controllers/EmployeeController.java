package com.gmail.andersoninfonet.employeemanager.controllers;

import java.util.List;

import com.gmail.andersoninfonet.employeemanager.models.Employee;
import com.gmail.andersoninfonet.employeemanager.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
    private final EmployeeService employeeService;

    /**
     * @param employeeService
     */
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    
    /** 
     * @return ResponseEntity<List<Employee>>
     */
    @GetMapping
    ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.findAllEmployees());
    }

    
    /** 
     * @param id
     * @return ResponseEntity<Employee>
     */
    @GetMapping("/{id}")
    ResponseEntity<Employee> getAllEmployees(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    
    /** 
     * @param emp
     * @return ResponseEntity<Employee>
     */
    @PostMapping
    ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(emp));
    }

    
    /** 
     * @param emp
     * @return ResponseEntity<Employee>
     */
    @PutMapping
    ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(emp));
    }

    
    /** 
     * @param id
     * @return ResponseEntity<Employee>
     */
    @DeleteMapping("/{id}")
    ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}
