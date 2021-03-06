package com.akash.parkinglot.model.payment;

import com.akash.parkinglot.model.parking.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Payment {
    private String transactionId;
    private Ticket ticket;
    private Double price;
    private LocalDateTime transactionStartTime;
    private LocalDateTime transactionEndTime;
    private PaymentStatus paymentStatus;


}
