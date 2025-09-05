package com.pro.billingPolicy;

import java.time.LocalDateTime;

public class Bill {

    final private String ticketNumber;
    final private double amount;
    final private double totalTIme;
    final private LocalDateTime localDateTime;

    public Bill(String ticketNumber,double amount, double totalTIme, LocalDateTime localDateTime) {
        this.amount = amount;
        this.totalTIme = totalTIme;
        this.localDateTime = localDateTime;
        this.ticketNumber = ticketNumber;
    }

    public double getAmount() {
        return amount;
    }

    public double getTotalTIme() {
        return totalTIme;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getTicketId() {
        return ticketNumber;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "ticketNumber='" + ticketNumber + '\'' +
                ", amount=" + amount +
                ", totalTIme=" + totalTIme +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
