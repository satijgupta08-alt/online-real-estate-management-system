package com.realstate.RS.repository;

import com.realstate.RS.entity.RentalAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalAgreementRepository
        extends JpaRepository<RentalAgreement, Long> {
}