package com.drone.drones.service;

import com.drone.drones.common.DroneModel;

import java.util.List;

public interface DroneService {

    void registerDrone(DroneModel droneModel);

    List<DroneModel> getDrones();

    List<DroneModel> getAvailableDroneForLoading();

    Double getBatteryLevelForDrone(long droneId);
}
