package com.gmail.andersoninfonet.employeemanager.repositories;

import java.util.List;
import java.util.Optional;

import com.gmail.andersoninfonet.employeemanager.models.Application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    
    Optional<Application> findByIdAndIsActive(Long id, Boolean isActive);

    List<Application> findByIsActive(Boolean isActive);
}
