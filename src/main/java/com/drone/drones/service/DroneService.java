package com.drone.drones.service;

import com.drone.drones.common.DroneModel;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface DroneService {

    void registerDrone(DroneModel droneModel) throws ValidationException;

    List<DroneModel> getDrones();

    List<DroneModel> getAvailableDroneForLoading();

    Double getBatteryLevelForDrone(long droneId);
}
