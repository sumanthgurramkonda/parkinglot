package com.pro.repository;

import com.pro.ticket.Ticket;

import java.util.HashMap;
import java.util.Map;

public class BillingRepo {
    Map<String, Ticket> ticketMap = new HashMap<>();
    private static BillingRepo instance = null;

    private BillingRepo(){}

    public static BillingRepo getInstance(){
        if(instance==null){
            synchronized (BillingRepo.class){
                if(instance==null){
                    instance = new BillingRepo();
                }
            }
        }
        return instance;
    }

    public void save(Ticket ticket){
        ticketMap.put(ticket.getTicketNumber(),ticket);
    }

    public Ticket getById(String id){
        return ticketMap.getOrDefault(id, null);
    }
}
