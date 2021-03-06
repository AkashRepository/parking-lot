package com.akash.parkinglot.service.strategy;

import com.akash.parkinglot.exception.NoEmptySpotAvailable;
import com.akash.parkinglot.model.parking.Floor;
import com.akash.parkinglot.model.parking.Spot;
import com.akash.parkinglot.model.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public class DefaultStrategy implements ParkingStrategy {
    @Override
    public Optional<Floor> getNextAvailableFloor(List<Floor> floors) {
        return Optional.empty();
    }

    @Override
    public Spot parkVehicle(Floor floor, Vehicle vehicle) throws NoEmptySpotAvailable {
        return null;
    }
}
