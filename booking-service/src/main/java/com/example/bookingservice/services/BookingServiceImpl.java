package com.example.bookingservice.services;

import com.example.bookingservice.dao.BookingInfoDao;
import com.example.bookingservice.dto.BookingInfoDTO;
import com.example.bookingservice.dto.BookingRequestDTO;
import com.example.bookingservice.dto.PaymentRequestDTO;
import com.example.bookingservice.entities.BookingInfoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;

@Component
public class BookingServiceImpl implements BookingService{

    ModelMapper modelMapper;
    BookingInfoDao bookingInfoDao;
    RestTemplate restTemplate;

    @Value("${api-gateway-url}")
    String apiGatewayUrl;

    @Autowired
    public BookingServiceImpl(ModelMapper modelMapper, BookingInfoDao bookingInfoDao, RestTemplate restTemplate) {
        this.modelMapper = modelMapper;
        this.bookingInfoDao = bookingInfoDao;
        this.restTemplate = restTemplate;
    }

    public static ArrayList<String> getRandomNumbers(int count){
        Random rand = new Random();
        int upperBound = 100;
        ArrayList<String>numberList = new ArrayList<String>();

        for (int i=0; i<count; i++){
            numberList.add(String.valueOf(rand.nextInt(upperBound)));
        }

        return numberList;
    }

    @Override
    public BookingInfoDTO getBookingInfo(BookingRequestDTO bookingRequestDTO) {

        int numOfDays = (int) ChronoUnit.DAYS.between(bookingRequestDTO.getFromDate(), bookingRequestDTO.getToDate());
        int roomPrice = 1000 * bookingRequestDTO.getNumOfRooms() * numOfDays;
        String roomNumbers = String.join(",", getRandomNumbers(bookingRequestDTO.getNumOfRooms()));

        BookingInfoEntity bookingInfoEntity = BookingInfoEntity.builder()
                .fromDate(bookingRequestDTO.getFromDate())
                .toDate(bookingRequestDTO.getToDate())
                .aadharNumber(bookingRequestDTO.getAadharNumber())
                .transactionId(0)
                .numOfRooms(bookingRequestDTO.getNumOfRooms())
                .roomNumbers(roomNumbers)
                .roomPrice(roomPrice)
                .bookedOn(LocalDate.now())
                .build();

        //Save in DB
        bookingInfoDao.save(bookingInfoEntity);

        //Return
        BookingInfoDTO bookingInfoDTO = modelMapper.map(bookingInfoEntity, BookingInfoDTO.class);
        return bookingInfoDTO;
    }

    @Override
    public BookingInfoDTO addPaymentDetails(int bookingId, PaymentRequestDTO paymentRequestDTO) {

        String paymentServiceUrl = apiGatewayUrl + "/payment/transaction";
        System.out.println(paymentServiceUrl);
        // Call payment-service API
        int transactionId = restTemplate.postForObject(paymentServiceUrl, paymentRequestDTO, Integer.class);

        // Update transactionId
        BookingInfoEntity bookingInfoEntity = bookingInfoDao.getById(bookingId);
        bookingInfoEntity.setTransactionId(transactionId);
        bookingInfoDao.save(bookingInfoEntity);


        //Return
        BookingInfoDTO bookingInfoDTO = modelMapper.map(bookingInfoEntity, BookingInfoDTO.class);
        return bookingInfoDTO;
    }
}
