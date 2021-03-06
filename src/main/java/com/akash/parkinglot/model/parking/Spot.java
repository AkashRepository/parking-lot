package com.akash.parkinglot.model.parking;

import com.akash.parkinglot.model.vehicle.Vehicle;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class Spot {
    private String name;
    private Vehicle vehicle;
    private Boolean isOccupied = Boolean.FALSE;
    private SpotType spotType;

}
