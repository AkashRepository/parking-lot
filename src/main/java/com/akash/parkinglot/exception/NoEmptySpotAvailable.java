package com.akash.parkinglot.exception;

public class NoEmptySpotAvailable extends Exception {

    public NoEmptySpotAvailable() {
        super();
    }

    public NoEmptySpotAvailable(String message) {
        super(message);
    }
}
