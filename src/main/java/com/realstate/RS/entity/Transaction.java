package com.realstate.RS.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long propertyId;

    private Long agreementId;

    private String tenantEmail;

    private Double amount;

    @Column(unique = true)
    private String transactionId;

    private String paymentMethod;

    private String status;

    private String transactionDate;

    public Transaction() {
    }

    public Transaction(
            Long propertyId,
            Long agreementId,
            String tenantEmail,
            Double amount,
            String transactionId,
            String paymentMethod,
            String status,
            String transactionDate) {

        this.propertyId = propertyId;
        this.agreementId = agreementId;
        this.tenantEmail = tenantEmail;
        this.amount = amount;
        this.transactionId = transactionId;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.transactionDate = transactionDate;
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

    public Long getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(Long agreementId) {
        this.agreementId = agreementId;
    }

    public String getTenantEmail() {
        return tenantEmail;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}