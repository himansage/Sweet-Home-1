package com.example.bookingservice.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "booking")
public class BookingInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private int transactionId;

    @Column
    private LocalDate bookedOn;

    @Override
    public String toString() {
        return "(bookingId: " + bookingId
                + ", fromDate: " + fromDate
                + ", toDate: " + toDate
                + ", aadharNumber: " + aadharNumber
                + ", numOfRooms: " + numOfRooms
                + ", roomNumbers: " + roomNumbers
                + ", roomPrice: " + roomPrice
                + ", transactionId: " + transactionId
                + ", bookedOn: " + bookedOn +")";
    }
}
