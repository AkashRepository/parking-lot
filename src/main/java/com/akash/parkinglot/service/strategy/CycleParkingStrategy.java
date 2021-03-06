package com.akash.parkinglot.service.strategy;

import com.akash.parkinglot.exception.NoEmptySpotAvailable;
import com.akash.parkinglot.model.parking.Floor;
import com.akash.parkinglot.model.parking.Spot;
import com.akash.parkinglot.model.parking.SpotType;
import com.akash.parkinglot.model.vehicle.Vehicle;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CycleParkingStrategy implements ParkingStrategy {

    @Override
    public Optional<Floor> getNextAvailableFloor(List<Floor> floors) {
        List<Floor> availableFloors = getAvailableFloors(floors);
        return availableFloors.stream()
                .filter(floor -> floor.getSpots().stream().anyMatch(spot -> !spot.getIsOccupied()
                        && spot.getSpotType().equals(SpotType.SMALL)))
                .findFirst();
    }

    @Override
    public Spot parkVehicle(Floor floor, Vehicle vehicle) throws NoEmptySpotAvailable {
        return floor.parkBasedOnSpotType(vehicle, SpotType.SMALL);
    }
}
