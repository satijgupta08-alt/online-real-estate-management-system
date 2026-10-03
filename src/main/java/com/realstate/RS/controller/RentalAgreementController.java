package com.realstate.RS.controller;

import com.realstate.RS.entity.RentalAgreement;
import com.realstate.RS.repository.RentalAgreementRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agreements")
@CrossOrigin
public class RentalAgreementController {

    private final RentalAgreementRepository agreementRepository;

    public RentalAgreementController(
            RentalAgreementRepository agreementRepository) {

        this.agreementRepository = agreementRepository;
    }

    // Create a rental agreement
    @PostMapping
    public RentalAgreement createAgreement(
            @RequestBody RentalAgreement agreement) {

        if (agreement.getStatus() == null ||
                agreement.getStatus().isEmpty()) {

            agreement.setStatus("ACTIVE");
        }

        return agreementRepository.save(agreement);
    }

    // Get all rental agreements
    @GetMapping
    public List<RentalAgreement> getAllAgreements() {

        return agreementRepository.findAll();
    }

    // Get agreement by ID
    @GetMapping("/{id}")
    public RentalAgreement getAgreementById(
            @PathVariable Long id) {

        return agreementRepository
                .findById(id)
                .orElse(null);
    }

    // Update rental agreement
    @PutMapping("/{id}")
    public RentalAgreement updateAgreement(
            @PathVariable Long id,
            @RequestBody RentalAgreement agreement) {

        RentalAgreement existingAgreement =
                agreementRepository
                        .findById(id)
                        .orElse(null);

        if (existingAgreement == null) {
            return null;
        }

        existingAgreement.setPropertyId(
                agreement.getPropertyId());

        existingAgreement.setTenantEmail(
                agreement.getTenantEmail());

        existingAgreement.setStartDate(
                agreement.getStartDate());

        existingAgreement.setEndDate(
                agreement.getEndDate());

        existingAgreement.setMonthlyRent(
                agreement.getMonthlyRent());

        existingAgreement.setStatus(
                agreement.getStatus());

        return agreementRepository.save(
                existingAgreement);
    }

    // Delete rental agreement
    @DeleteMapping("/{id}")
    public String deleteAgreement(
            @PathVariable Long id) {

        if (!agreementRepository.existsById(id)) {

            return "Rental agreement not found";
        }

        agreementRepository.deleteById(id);

        return "Rental agreement deleted successfully";
    }
}