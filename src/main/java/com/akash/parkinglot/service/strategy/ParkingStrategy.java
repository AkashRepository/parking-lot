package com.akash.parkinglot.service.strategy;

import com.akash.parkinglot.exception.NoEmptySpotAvailable;
import com.akash.parkinglot.model.parking.Floor;
import com.akash.parkinglot.model.parking.Spot;
import com.akash.parkinglot.model.parking.SpotType;
import com.akash.parkinglot.model.parking.Ticket;
import com.akash.parkinglot.model.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface ParkingStrategy {

    default List<Floor> getAvailableFloors(List<Floor> floors) {
        return floors.stream().filter(floor -> floor.getNumberOfSpotsAvailable() > 0).collect(Collectors.toList());
    }

    Optional<Floor> getNextAvailableFloor(List<Floor> floors);

    Spot parkVehicle(Floor floor, Vehicle vehicle) throws NoEmptySpotAvailable;

}
