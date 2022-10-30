package com.drone.drones.service.impl;

import com.drone.drones.common.DroneModel;
import com.drone.drones.repository.DroneRepository;
import com.drone.drones.repository.entity.Drone;
import com.drone.drones.service.DroneService;
import com.drone.drones.service.mapper.DroneMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DroneServiceImpl implements DroneService {
    @Autowired private DroneRepository droneRepository;
    @Autowired private DroneMapper droneMapper;


    @Override
    public void registerDrone(DroneModel droneModel) {
        log.info("register drone");
        Drone drone = droneMapper.toEntity(droneModel);
        droneRepository.save(drone);
    }

    @Override
    public List<DroneModel> getDrones() {
        log.info("getDrones::find all drones");
        List<Drone> drones = droneRepository.findAll();
        return drones.stream().map(droneMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public List<DroneModel> getAvailableDroneForLoading() {
        log.info("getAvailableDroneForLoading::checking available drones for loading");
        List<Drone> drones = droneRepository.getAvailableDrones();
        return drones.stream().map(droneMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Double getBatteryLevelForDrone(long droneId) {
        log.info("getBatteryLevelForDrone::check drone battery level");
        return droneRepository.getDroneBatteryLevel(droneId);
    }
}
