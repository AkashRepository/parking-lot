package com.akash.parkinglot.model.payment;

import com.akash.parkinglot.model.parking.Spot;
import com.akash.parkinglot.model.parking.Ticket;
import com.akash.parkinglot.service.strategy.PaymentStrategy;

public class CashPayment implements PaymentStrategy {

    @Override
    public Payment calculate(Ticket ticket) {
        return null;
    }

    @Override
    public Payment pay(Payment payment) {
        return null;
    }
}
