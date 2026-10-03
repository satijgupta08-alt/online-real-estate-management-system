package com.realstate.RS.controller;

import com.realstate.RS.entity.RentalApplication;
import com.realstate.RS.repository.RentalApplicationRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin
public class RentalApplicationController {

    private final RentalApplicationRepository applicationRepository;

    public RentalApplicationController(
            RentalApplicationRepository applicationRepository) {

        this.applicationRepository = applicationRepository;
    }

    // Submit a rental application
    @PostMapping
    public RentalApplication applyForProperty(
            @RequestBody RentalApplication application) {

        if (application.getStatus() == null ||
                application.getStatus().isEmpty()) {

            application.setStatus("PENDING");
        }

        return applicationRepository.save(application);
    }

    // Get all rental applications
    @GetMapping
    public List<RentalApplication> getAllApplications() {
        return applicationRepository.findAll();
    }

    // Get application by ID
    @GetMapping("/{id}")
    public RentalApplication getApplicationById(
            @PathVariable Long id) {

        return applicationRepository.findById(id).orElse(null);
    }

    // Update application status
    @PutMapping("/{id}/status")
    public RentalApplication updateApplicationStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        RentalApplication application =
                applicationRepository.findById(id).orElse(null);

        if (application == null) {
            return null;
        }

        application.setStatus(status);

        return applicationRepository.save(application);
    }

    // Delete application
    @DeleteMapping("/{id}")
    public String deleteApplication(@PathVariable Long id) {

        if (!applicationRepository.existsById(id)) {
            return "Application not found";
        }

        applicationRepository.deleteById(id);

        return "Application deleted successfully";
    }
}