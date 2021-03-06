package com.akash.parkinglot.exception;

public class PaymentFailedException extends Exception {
    public PaymentFailedException(String paymentFailed) {
        super(paymentFailed);
    }
}
