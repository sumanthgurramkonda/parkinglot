package com.pro.billingPolicy;

import com.pro.ticket.Ticket;
import com.pro.vehicle.Vehicle;

interface BillingPolicy {
    Bill generateBill(Ticket ticket);
}
