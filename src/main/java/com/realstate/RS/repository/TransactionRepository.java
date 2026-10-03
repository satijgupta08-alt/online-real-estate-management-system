package com.realstate.RS.repository;

import com.realstate.RS.entity.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    List<Transaction> findByTenantEmail(String tenantEmail);
}