package com.pro.parkings;

import com.pro.enums.SlotState;
import com.pro.enums.SlotType;
import com.pro.enums.VehicleType;
import com.pro.vehicle.Bike;
import com.pro.vehicle.Car;
import com.pro.vehicle.Vehicle;

public class ParkingSlot {

    private int slotId;
    private SlotState slotState;
    private SlotType slotType;
    private Vehicle vehicle;

    public ParkingSlot(int slotId, SlotState slotState, SlotType slotType) {
        this.slotId = slotId;
        this.slotState = slotState;
        this.slotType = slotType;
    }

    public boolean canFit(Vehicle vehicle){
        return ((vehicle instanceof Bike && vehicle.getVehicleType()== VehicleType.SMALL)||
                (vehicle instanceof Car && vehicle.getVehicleType()== VehicleType.MEDIUM)||
                (vehicle instanceof Bike && vehicle.getVehicleType()== VehicleType.LARGE));
    }

    public boolean getIsAvailable(){
        return slotState==SlotState.FREE;
    }

    public boolean reserveSlot(Vehicle vehicle){
        this.vehicle = vehicle;
        slotState=SlotState.OCCUPIED;
        return true;
    }

    public void vacateSlot(){
        this.vehicle = null;
        slotState=SlotState.FREE;
    }

}
