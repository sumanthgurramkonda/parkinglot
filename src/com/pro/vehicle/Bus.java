package com.pro.vehicle;

import com.pro.enums.VehicleType;

public class Bus extends Vehicle{

    public Bus(long vehicleNumber){
        super(vehicleNumber,VehicleType.LARGE);
    }
}
