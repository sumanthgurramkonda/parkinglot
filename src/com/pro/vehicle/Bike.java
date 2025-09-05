package com.pro.vehicle;

import com.pro.enums.VehicleType;

public class Bike extends Vehicle{

    public Bike(long vehicleNumber){
        super(vehicleNumber,VehicleType.SMALL);
    }
}
