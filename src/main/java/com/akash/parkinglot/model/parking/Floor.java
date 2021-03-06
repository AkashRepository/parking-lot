package com.akash.parkinglot.model.parking;

import com.akash.parkinglot.exception.NoEmptySpotAvailable;
import com.akash.parkinglot.model.vehicle.Vehicle;
import com.akash.parkinglot.service.strategy.ParkingStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class Floor {
    private String name;
    private Integer level;
    private Integer capacity;
    private Integer numberOfSpotsAvailable;
    private List<Spot> spots;

    public Spot parkBasedOnSpotType(Vehicle vehicle, SpotType spotType) throws NoEmptySpotAvailable {
        if (numberOfSpotsAvailable > 0) {
            Spot spot = Spot.builder().spotType(spotType).isOccupied(true)
                    .vehicle(vehicle).build();
            spots.add(spot);
            numberOfSpotsAvailable--;
        }
        throw new NoEmptySpotAvailable("No slots available");
    }
}
