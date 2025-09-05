package com.pro.repository;

import com.pro.parkings.ParkingLevel;
import com.pro.parkings.ParkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepo {
    Map<String, List<ParkingLevel>> parkingLotMap = new HashMap<>();
    private static ParkingLotRepo instance;

    private ParkingLotRepo(){}

    public static ParkingLotRepo getInstance(){
        if(instance==null){
            synchronized (ParkingLotRepo.class){
                if(instance==null){
                    instance = new ParkingLotRepo();
                }
            }
        }
        return instance;
    }

    public void save(String lotId, List<ParkingLevel> parkingLevels){
        parkingLotMap.put(lotId,parkingLevels);
    }

    public List<ParkingLevel> getById(String id){
        return parkingLotMap.getOrDefault(id, null);
    }
}
