package com.example.bookingservice.controllers;

import com.example.bookingservice.dto.BookingInfoDTO;
import com.example.bookingservice.dto.BookingRequestDTO;
import com.example.bookingservice.dto.PaymentRequestDTO;
import com.example.bookingservice.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    /**
     * POST /booking
     * @param bookingRequestDTO
     * @return
     */
    @PostMapping("/booking")
    public ResponseEntity<BookingInfoDTO> getBookingInfo(@RequestBody BookingRequestDTO bookingRequestDTO) {

        BookingInfoDTO bookingInfoDTO = bookingService.getBookingInfo(bookingRequestDTO);

        return new ResponseEntity<>(bookingInfoDTO, HttpStatus.CREATED);
    }

    /**
     * POST /booking/{bookingId}/transaction
     * @param bookingId
     * @param paymentRequestDTO
     * @return
     */
    @PostMapping("booking/{bookingId}/transaction")
    public ResponseEntity<BookingInfoDTO> addPaymentDetails(@PathVariable(name = "bookingId") int bookingId, @RequestBody PaymentRequestDTO paymentRequestDTO) {

        BookingInfoDTO bookingInfoDTO = bookingService.addPaymentDetails(bookingId, paymentRequestDTO);

        return new ResponseEntity<>(bookingInfoDTO, HttpStatus.CREATED);
    }
}
