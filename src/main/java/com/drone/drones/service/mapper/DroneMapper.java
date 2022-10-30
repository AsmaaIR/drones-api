package com.drone.drones.service.mapper;

import com.drone.drones.common.DroneModel;
import com.drone.drones.repository.entity.Drone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DroneMapper {

    Drone toEntity(final DroneModel droneModel);

    DroneModel toModel(final Drone drone);

}