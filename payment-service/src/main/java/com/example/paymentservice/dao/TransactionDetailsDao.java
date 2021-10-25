package com.example.paymentservice.dao;

import com.example.paymentservice.entities.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailsDao extends JpaRepository<TransactionDetailsEntity, Integer> {
}
