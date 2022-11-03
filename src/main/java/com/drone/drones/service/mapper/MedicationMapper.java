package com.drone.drones.service.mapper;

import com.drone.drones.common.MedicationModel;
import com.drone.drones.repository.entity.Medication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicationMapper {

    @Mapping(target = "droneData", source = "medication.droneData", ignore = true)
    MedicationModel toModel(final Medication medication);

    @Mapping(target = "droneData", source = "medicationModel.droneData", ignore = true)
    Medication toEntity (final MedicationModel medicationModel);

    List<Medication> toEntities (final List<MedicationModel> medicationModels);
}