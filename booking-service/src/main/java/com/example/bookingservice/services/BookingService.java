package com.example.bookingservice.services;

import com.example.bookingservice.dto.BookingInfoDTO;
import com.example.bookingservice.dto.BookingRequestDTO;
import com.example.bookingservice.dto.PaymentRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {

    BookingInfoDTO getBookingInfo(BookingRequestDTO bookingRequestDTO);

    BookingInfoDTO addPaymentDetails(int bookingId, PaymentRequestDTO paymentRequestDTO);
}
