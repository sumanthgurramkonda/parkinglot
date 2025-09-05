package com.pro.vehicle;

import com.pro.enums.VehicleType;

public class Car extends Vehicle{

    public Car(long vehicleNumber){
        super(vehicleNumber,VehicleType.MEDIUM);
    }

}
