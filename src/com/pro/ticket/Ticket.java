package com.pro.ticket;

import com.pro.parkings.ParkingLot;
import com.pro.parkings.ParkingSlot;
import com.pro.vehicle.Vehicle;

import java.time.LocalDateTime;

public class Ticket {

    private String ticketNumber;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private LocalDateTime bookingTime;
    private LocalDateTime exitTime;
    private int amount;

    public Ticket(String ticketNumber, Vehicle vehicle, ParkingSlot parkingSlot, LocalDateTime bookingTime) {
        this.ticketNumber = ticketNumber;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.bookingTime = bookingTime;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber='" + ticketNumber + '\'' +
                ", vehicle=" + vehicle +
                ", parkingSlot=" + parkingSlot +
                ", bookingTime=" + bookingTime +
                ", exitTime=" + exitTime +
                ", amount=" + amount +
                '}';
    }
}
