package com.example.bookingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "booking")
public class BookingInfoEntity {

    @Id
    private int bookingId;

    @Column
    private LocalDate fromDate;

    @Column
    private LocalDate toDate;

    @Column
    private String aadharNumber;

    @Column
    private int numOfRooms;

    @Column
    private String roomNumbers;

    @Column(nullable = false)
    private int roomPrice;

    @Column
    private int transactionId = 0;

    @Column
    private LocalDate bookedOn;
}
