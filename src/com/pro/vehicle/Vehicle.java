package com.pro.vehicle;

import com.pro.enums.VehicleType;

public class Vehicle {
    final long vehicleNumber;
    final VehicleType vehicleType;

    public Vehicle(long vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public long getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
