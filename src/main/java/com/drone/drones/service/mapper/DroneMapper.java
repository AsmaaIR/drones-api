package com.drone.drones.service.mapper;

import com.drone.drones.common.DroneModel;
import com.drone.drones.repository.entity.Drone;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DroneMapper {

    Drone toEntity(final DroneModel droneModel);

    List<DroneModel> toModels(final List<Drone> drones);

}