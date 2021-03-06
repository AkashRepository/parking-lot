package com.akash.parkinglot.model.vehicle;

import com.akash.parkinglot.model.common.Person;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class Vehicle {

    private String modelName;
    private String licenseNumber;
    private Person owner;
    private VehicleType vehicleType;

}
