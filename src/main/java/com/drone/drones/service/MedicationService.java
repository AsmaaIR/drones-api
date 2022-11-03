package com.drone.drones.service;

import com.drone.drones.common.MedicationModel;

import java.util.List;

public interface MedicationService {

    List<MedicationModel> getMedicationsByDroneId(long droneId);

}
