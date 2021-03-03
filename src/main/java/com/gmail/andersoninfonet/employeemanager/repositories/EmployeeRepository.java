package com.gmail.andersoninfonet.employeemanager.repositories;

import com.gmail.andersoninfonet.employeemanager.models.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
