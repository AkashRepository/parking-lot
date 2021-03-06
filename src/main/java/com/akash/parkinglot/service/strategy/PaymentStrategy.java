package com.akash.parkinglot.service.strategy;

import com.akash.parkinglot.model.parking.Spot;
import com.akash.parkinglot.model.parking.Ticket;
import com.akash.parkinglot.model.payment.Payment;
import com.akash.parkinglot.model.vehicle.Vehicle;

public interface PaymentStrategy {

    Payment calculate(Ticket ticket);
    Payment pay(Payment payment);
}
