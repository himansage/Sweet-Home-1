package com.example.paymentservice.services;

import com.example.paymentservice.dao.TransactionDetailsDao;
import com.example.paymentservice.dto.PaymentRequestDTO;
import com.example.paymentservice.dto.TransactionDetailsDTO;
import com.example.paymentservice.entities.TransactionDetailsEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionDetailsDao transactionDetailsDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public int performTransaction(PaymentRequestDTO paymentRequestDTO) {

        // Save the transaction entry in db
        TransactionDetailsEntity transactionDetailsEntity = TransactionDetailsEntity.builder()
                .bookingId(paymentRequestDTO.getBookingId())
                .upiId(paymentRequestDTO.getUpiId())
                .paymentMode(paymentRequestDTO.getPaymentMode())
                .cardNumber(paymentRequestDTO.getCardNumber())
                .build();

        transactionDetailsDao.save(transactionDetailsEntity);

        // Return transactionId
        return transactionDetailsEntity.getId();
    }

    @Override
    public TransactionDetailsDTO getTransactionDetails(int transactionId) {

        TransactionDetailsEntity transactionDetailsEntity = transactionDetailsDao.getById(transactionId);
        TransactionDetailsDTO transactionDetailsDTO = modelMapper.map(transactionDetailsEntity, TransactionDetailsDTO.class);

        return transactionDetailsDTO;
    }
}
