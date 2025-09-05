package com.pro.service;

import com.pro.billingPolicy.Bill;
import com.pro.parkings.ParkingLevel;
import com.pro.parkings.ParkingLot;
import com.pro.parkings.ParkingManger;
import com.pro.parkings.ParkingSlot;
import com.pro.repository.BillingRepo;
import com.pro.repository.ParkingLotRepo;
import com.pro.repository.VehicleRepo;
import com.pro.ticket.Ticket;
import com.pro.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public class ParkingLotService {

    private BillingRepo billingRepo;
    private ParkingLotRepo parkingLotRepo;
    private VehicleRepo vehicleRepo;
    private ParkingManger parkingManger;

    public ParkingLotService() {
        this.billingRepo = BillingRepo.getInstance();
        this.parkingLotRepo = ParkingLotRepo.getInstance();
        this.vehicleRepo = VehicleRepo.getInstance();
        this.parkingManger = ParkingManger.getInstance();
    }

    public void setUpParking(String lotId, List<ParkingLevel> parkingLevels){
        parkingManger.setParking(lotId,parkingLevels);
        parkingLotRepo.save(lotId,parkingLevels);
    }

    public Ticket reserveSlot(String lotId,Vehicle vehicle){
        Optional<Ticket> ticket = parkingManger.reserveSlot(lotId, vehicle);
        billingRepo.save(ticket.get());
        vehicleRepo.save(vehicle);
        return ticket.get();
    }

    public Bill vacateSlot(String ticketNumber){
        Ticket ticket = billingRepo.getById(ticketNumber);
        Bill bill = parkingManger.vacateSlot(ticket);
        if(bill!=null){
            billingRepo.save(ticket);
        }
        return bill;
    }


}
