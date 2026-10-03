package com.realstate.RS.repository;

import com.realstate.RS.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository
        extends JpaRepository<Application, Long> {

    List<Application> findByTenantId(Long tenantId);

    List<Application> findByPropertyId(Long propertyId);
}