package com.akash.parkinglot.model.parking;

import com.akash.parkinglot.exception.PaymentFailedException;
import com.akash.parkinglot.exception.NoEmptySpotAvailable;
import com.akash.parkinglot.model.common.Address;
import com.akash.parkinglot.model.payment.*;
import com.akash.parkinglot.model.vehicle.Vehicle;
import com.akash.parkinglot.service.strategy.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
public class ParkingLot {

    private String name;
    private List<Panel> panels;
    private List<Floor> floors;
    private Address address;


    public Ticket parkVehicle(Vehicle vehicle) throws NoEmptySpotAvailable {
        ParkingStrategy parkingStrategy = getParkingStrategy(vehicle);

        Optional<Floor> floorOptional = getNextAvailableFloor(parkingStrategy);
        if (floorOptional.isPresent()) {
            Spot spot = parkingStrategy.parkVehicle(floorOptional.get(), vehicle);
            return createParkingTicket(spot);
        }
        throw new NoEmptySpotAvailable("No space available for this spotType");
    }

    private Ticket createParkingTicket(Spot spot) {
        return Ticket.builder().spot(spot)
                .ticketNumber(UUID.randomUUID().toString())
                .ticketStatus(TicketStatus.CREATED)
                .issuedTime(LocalDateTime.now())
                .build();

    }

    public String payment(Ticket ticket, PaymentMode paymentMode) throws PaymentFailedException{

        PaymentStrategy paymentStrategy = getParkingStrategy(paymentMode);
        assert paymentStrategy != null;
        Payment paymentAmount = paymentStrategy.calculate(ticket);
        Payment pay = paymentStrategy.pay(paymentAmount);
        if (pay.getPaymentStatus().equals(PaymentStatus.SUCCESS)) {
            ticket.setTicketStatus(TicketStatus.ACTIVE);
            return pay.getTransactionId();
        }
        throw new PaymentFailedException("Payment Failed");
    }

    private PaymentStrategy getParkingStrategy(PaymentMode paymentMode) {
        switch (paymentMode) {
            case DEBIT_CARD:
                return new DebitCardPayment();
            case CASH:
                return new CashPayment();
        }
        return null;
    }


    private Optional<Floor> getNextAvailableFloor(ParkingStrategy parkingStrategy) {
        return parkingStrategy.getNextAvailableFloor(this.floors);
    }

    private ParkingStrategy getParkingStrategy(Vehicle vehicle) {
        switch (vehicle.getVehicleType()) {
            case CYCLE:
                return new CycleParkingStrategy();
            case FOUR_WHEELER:
                return new FourWheelerParkingStrategy();
            default:
                return new DefaultStrategy();
        }
    }


}
