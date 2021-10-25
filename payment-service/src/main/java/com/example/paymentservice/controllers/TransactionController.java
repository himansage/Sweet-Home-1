package com.example.paymentservice.controllers;

import com.example.paymentservice.dto.PaymentRequestDTO;
import com.example.paymentservice.dto.TransactionDetailsDTO;
import com.example.paymentservice.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction")
    public ResponseEntity<Integer> handleTransactionRequest(@RequestBody PaymentRequestDTO paymentRequestDTO) {

        int transactionId = transactionService.performTransaction(paymentRequestDTO);

        return new ResponseEntity<>(transactionId, HttpStatus.CREATED);
    }

    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity<TransactionDetailsDTO> getTransactionDetails(@PathVariable(name = "transactionId") int transactionId) {

        TransactionDetailsDTO transactionDetailsDTO = transactionService.getTransactionDetails(transactionId);

        return new ResponseEntity(transactionDetailsDTO, HttpStatus.OK);
    }
}
