package com.drone.drones.service.mapper;

import com.drone.drones.common.MedicationModel;
import com.drone.drones.repository.entity.Medication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MedicationMapper {

    @Mapping(target = "medications.droneData", ignore = true)
    MedicationModel toModel(final Medication medications);
}