package com.gmail.andersoninfonet.employeemanager.services;

import java.util.List;
import java.util.UUID;

import com.gmail.andersoninfonet.employeemanager.exception.EmployeeNotFoundException;
import com.gmail.andersoninfonet.employeemanager.models.Employee;
import com.gmail.andersoninfonet.employeemanager.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    private final EmployeeRepository employeeRepository;

    /**
     * @param employeeRepository
     */
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    
    /** 
     * @param emp
     * @return Employee
     */
    public Employee addEmployee(Employee emp) {
        emp.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(emp);
    }

    
    /** 
     * @return List<Employee>
     */
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    
    
    /** 
     * @param id
     * @return Employee
     */
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee Not found."));
    }

    
    /** 
     * @param emp
     * @return Employee
     */
    public Employee updateEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    
    /** 
     * @param id
     */
    public void deleteEmployee(Long id) {
        Employee emp = findById(id);
        employeeRepository.deleteById(emp.getId());
        
    }
}
