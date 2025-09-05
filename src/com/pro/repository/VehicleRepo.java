package com.pro.repository;

import com.pro.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepo {

    Map<Long, Vehicle> vehicleMap = new HashMap<>();
    private static VehicleRepo instance;

    private VehicleRepo(){}

    public static VehicleRepo getInstance(){
        if(instance==null){
            synchronized (VehicleRepo.class){
                if(instance==null){
                    instance = new VehicleRepo();
                }
            }
        }
        return instance;
    }
    public void save(Vehicle vehicle){
        vehicleMap.put(vehicle.getVehicleNumber(),vehicle);
    }

    public Vehicle getById(Long id){
        return vehicleMap.getOrDefault(id, null);
    }
}
