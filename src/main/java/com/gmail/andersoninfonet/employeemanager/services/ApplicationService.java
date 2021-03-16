package com.gmail.andersoninfonet.employeemanager.services;

import com.gmail.andersoninfonet.employeemanager.repositories.ApplicationRepository;

import java.util.List;

import com.gmail.andersoninfonet.employeemanager.exception.ApplicationNotFoundException;
import com.gmail.andersoninfonet.employeemanager.models.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository;
    /**
     * @param applicationRepository
     */
    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    
    /** 
     * @param app
     * @return Application
     */
    public Application addApplication(Application app) {
        return applicationRepository.save(app);
    }

    
    /** 
     * @return List<Application>
     */
    public List<Application> findAllApplications() {
        return applicationRepository.findByIsActive(Boolean.TRUE);
    }

    
    
    /** 
     * @param id
     * @return Application
     */
    public Application findById(Long id) {
        return applicationRepository.findByIdAndIsActive(id, Boolean.TRUE).orElseThrow(() -> new ApplicationNotFoundException("Application Not found."));
    }

    
    /** 
     * @param app
     * @return Application
     */
    public Application updateApplication(Application app) {
        return applicationRepository.save(app);
    }

    
    /** 
     * @param id
     */
    public void deleteApplication(Long id) {
        Application app = findById(id);
        applicationRepository.deleteById(app.getId());
        
    }
}
