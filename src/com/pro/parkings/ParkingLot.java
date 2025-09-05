package com.pro.parkings;

import com.pro.ticket.Ticket;
import com.pro.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public class ParkingLot {
    private String lotId;
    private List<ParkingLevel> parkingLevels;

    public ParkingLot(String lotId, List<ParkingLevel> parkingLevels) {
        this.lotId = lotId;
        this.parkingLevels = parkingLevels;
    }

    public String getLotId() {
        return lotId;
    }

    public ParkingSlot reserveParkingSlot(Vehicle vehicle){
        for(ParkingLevel parkingLevel : parkingLevels){
            Optional<ParkingSlot> parkingSlot = parkingLevel.findAvailalbeSlots(vehicle);
            parkingSlot.get().reserveSlot(vehicle);
            return parkingSlot.get();
        }
        return null;
    }

    public void vacateSlot(){

    }
}
