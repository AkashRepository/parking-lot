package com.akash.parkinglot.model.parking;

import com.akash.parkinglot.model.payment.Price;
import com.akash.parkinglot.model.vehicle.Vehicle;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Ticket {
    private String  ticketNumber;
    private Spot spot;
    private Price price;
    private LocalDateTime issuedTime;
    private LocalDateTime exitTime;
    private TicketStatus ticketStatus;
}
