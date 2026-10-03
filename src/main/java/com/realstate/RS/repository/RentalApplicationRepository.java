package com.realstate.RS.repository;

import com.realstate.RS.entity.RentalApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalApplicationRepository
        extends JpaRepository<RentalApplication, Long> {
}
