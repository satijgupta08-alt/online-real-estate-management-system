package com.realstate.RS.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rental_applications")
public class RentalApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long propertyId;

    private String tenantEmail;

    private String status;

    public RentalApplication() {
    }

    public RentalApplication(Long propertyId, String tenantEmail, String status) {
        this.propertyId = propertyId;
        this.tenantEmail = tenantEmail;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getTenantEmail() {
        return tenantEmail;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
