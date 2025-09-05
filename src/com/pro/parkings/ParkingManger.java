package com.pro.parkings;

import com.pro.billingPolicy.Bill;
import com.pro.billingPolicy.HourlyBillingPolicy;
import com.pro.service.ParkingLotService;
import com.pro.ticket.Ticket;
import com.pro.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ParkingManger {

    private List<ParkingLot> parkingLots;
    private static ParkingManger instance;

    private ParkingManger(){
        this.parkingLots = new ArrayList<>();
    }

    public static ParkingManger getInstance(){
        if(instance==null){
            synchronized (ParkingManger.class){
                if(instance==null){
                    instance = new ParkingManger();
                }
            }
        }
        return instance;
    }

    public void setParking(String lotId, List<ParkingLevel> parkingLevels){
        parkingLots.add(new ParkingLot(lotId,parkingLevels));
    }

    public synchronized Optional<Ticket> reserveSlot(String lotId, Vehicle vehicle){
        Ticket ticket = null;
        for(ParkingLot parkingLot : parkingLots) {
            ParkingSlot parkingSlot = parkingLot.reserveParkingSlot(vehicle);
            if (parkingSlot != null){
                ticket = new Ticket(UUID.randomUUID().toString(), vehicle, parkingSlot, LocalDateTime.now());
                break;
            }
        }
        return Optional.ofNullable(ticket);
    }

    public Bill vacateSlot(Ticket ticket){
        ticket.getParkingSlot().vacateSlot();
        return HourlyBillingPolicy.getInstance().generateBill(ticket);
    }

}
