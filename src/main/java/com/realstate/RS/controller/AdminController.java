package com.realstate.RS.controller;

import com.realstate.RS.repository.UserRepository;
import com.realstate.RS.repository.PropertyRepository;
import com.realstate.RS.repository.RentalApplicationRepository;
import com.realstate.RS.repository.RentalAgreementRepository;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

    private final UserRepository userRepository;
    private final PropertyRepository propertyRepository;
    private final RentalApplicationRepository applicationRepository;
    private final RentalAgreementRepository agreementRepository;

    public AdminController(
            UserRepository userRepository,
            PropertyRepository propertyRepository,
            RentalApplicationRepository applicationRepository,
            RentalAgreementRepository agreementRepository) {

        this.userRepository = userRepository;
        this.propertyRepository = propertyRepository;
        this.applicationRepository = applicationRepository;
        this.agreementRepository = agreementRepository;
    }

    // Get Admin Dashboard Statistics
    @GetMapping("/dashboard")
    public Map<String, Long> getDashboardStats() {

        Map<String, Long> stats = new HashMap<>();

        stats.put("totalUsers", userRepository.count());
        stats.put("totalProperties", propertyRepository.count());
        stats.put("totalApplications", applicationRepository.count());
        stats.put("totalAgreements", agreementRepository.count());

        return stats;
    }
}