package com.example.bookingservice.dao;

import com.example.bookingservice.entities.BookingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingInfoDao extends JpaRepository<BookingInfoEntity, Integer> {
}
