package com.gmail.andersoninfonet.employeemanager.controllers;

import com.gmail.andersoninfonet.employeemanager.services.ApplicationService;

import java.util.List;

import com.gmail.andersoninfonet.employeemanager.models.Application;

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
@RequestMapping("/applications")
public class ApplicationController {
    
    private final ApplicationService applicationService;

    /**
     * @param applicationService
     */
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

        
    /** 
     * @return ResponseEntity<List<Application>>
     */
    @GetMapping
    ResponseEntity<List<Application>> getAllApplications() {
        return ResponseEntity.ok(applicationService.findAllApplications());
    }

    
    /** 
     * @param id
     * @return ResponseEntity<Application>
     */
    @GetMapping("/{id}")
    ResponseEntity<Application> getAllApplications(@PathVariable("id") Long id) {
        return ResponseEntity.ok(applicationService.findById(id));
    }

    
    /** 
     * @param app
     * @return ResponseEntity<Application>
     */
    @PostMapping
    ResponseEntity<Application> addApplication(@RequestBody Application app) {
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationService.addApplication(app));
    }

    
    /** 
     * @param app
     * @return ResponseEntity<Application>
     */
    @PutMapping
    ResponseEntity<Application> updateApplication(@RequestBody Application app) {
        return ResponseEntity.status(HttpStatus.OK).body(applicationService.updateApplication(app));
    }

    
    /** 
     * @param id
     * @return ResponseEntity<Application>
     */
    @DeleteMapping("/{id}")
    ResponseEntity<Application> deleteApplication(@PathVariable("id") Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.ok().build();
    }
}
