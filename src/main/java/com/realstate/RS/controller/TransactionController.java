package com.realstate.RS.controller;

import com.realstate.RS.entity.Transaction;
import com.realstate.RS.repository.TransactionRepository;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin
public class TransactionController {

    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // Create a new transaction
    @PostMapping
    public Transaction createTransaction(
            @RequestBody Transaction transaction) {

        transaction.setTransactionId(
                "TXN-" +
                UUID.randomUUID()
                        .toString()
                        .substring(0, 8)
                        .toUpperCase()
        );

        transaction.setStatus("SUCCESS");

        transaction.setTransactionDate(
                LocalDateTime.now().toString()
        );

        return transactionRepository.save(transaction);
    }

    // Get all transactions
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Get transactions of a particular tenant
    @GetMapping("/tenant/{email}")
    public List<Transaction> getTenantTransactions(
            @PathVariable String email) {

        return transactionRepository
                .findByTenantEmail(email);
    }

    // Get transaction by ID
    @GetMapping("/{id}")
    public Transaction getTransactionById(
            @PathVariable Long id) {

        return transactionRepository
                .findById(id)
                .orElse(null);
    }
}