package com.pro.billingPolicy;

import com.pro.repository.BillingRepo;
import com.pro.ticket.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyBillingPolicy implements BillingPolicy {

    private static HourlyBillingPolicy instance;

    private HourlyBillingPolicy(){}

    public static HourlyBillingPolicy getInstance(){
        if(instance==null){
            synchronized (HourlyBillingPolicy.class){
                if(instance==null){
                    instance = new HourlyBillingPolicy();
                }
            }
        }
        return instance;
    }

    public Bill generateBill(Ticket ticket){
        LocalDateTime bookingTime = ticket.getBookingTime();
        LocalDateTime currentDateTime = LocalDateTime.now();
        Duration duration = Duration.between(bookingTime, currentDateTime);
        double totalSeconds = duration.getSeconds() + (duration.getNano()/ 1_000_000_000.0);
        double totalHours = totalSeconds/3600;
        totalHours = Math.round(totalHours * 10000.0) / 10000.0;
        double cost = 0;
        switch (ticket.getVehicle().getVehicleType()){
            case SMALL:
                cost = Price.BIKE_PRICE;
                break;
            case MEDIUM:
                cost = Price.CAR_PRICE;
                break;
            case LARGE:
                cost = Price.BUS_PRICE;
                break;
            default:
                throw new IllegalStateException("No such vehicle type("+ticket.getVehicle().getVehicleType()+") exists ");
        }
        return new Bill(ticket.getTicketNumber(), totalHours, totalHours * cost, currentDateTime);
    }
}
