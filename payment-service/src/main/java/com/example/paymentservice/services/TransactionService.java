package com.example.paymentservice.services;

import com.example.paymentservice.dto.PaymentRequestDTO;
import com.example.paymentservice.dto.TransactionDetailsDTO;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

    int performTransaction(PaymentRequestDTO paymentRequestDTO);

    TransactionDetailsDTO getTransactionDetails(int transactionId);
}
