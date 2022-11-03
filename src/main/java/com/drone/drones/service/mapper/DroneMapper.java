package com.drone.drones.service.mapper;

import com.drone.drones.common.DroneModel;
import com.drone.drones.common.constant.ModelTypeEnum;
import com.drone.drones.repository.entity.Drone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = { MedicationMapper.class})
public interface DroneMapper {

    @Mapping(source = "droneModel.model", target = "model", qualifiedByName = "getModelEnum")
    Drone toEntity(final DroneModel droneModel);

    DroneModel toModel(final Drone drone);

    @Named("getModelEnum")
    default ModelTypeEnum getModelEnum(String model) {
        return ModelTypeEnum.fromValue(model);
    }


}