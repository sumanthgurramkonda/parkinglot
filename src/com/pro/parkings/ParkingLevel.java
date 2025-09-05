package com.pro.parkings;

import com.pro.ticket.Ticket;
import com.pro.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public class ParkingLevel {

    private int level;
    private List<ParkingSlot> parkingSlots;

    public ParkingLevel(int level, List<ParkingSlot> parkingSlots){
        this.level = level;
        this.parkingSlots = parkingSlots;
    }

    public int getLevel() {
        return level;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public Optional<ParkingSlot> findAvailalbeSlots(Vehicle vehicle){
        return parkingSlots.stream()
                .filter(parkingSlot -> parkingSlot.canFit(vehicle))
                .findFirst();
    }

    public void vacateSlot(ParkingSlot parkingSlot){
        parkingSlot.vacateSlot();
    }

}
