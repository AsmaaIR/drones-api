package com.drone.drones.service.mapper;

import com.drone.drones.common.MedicationModel;
import com.drone.drones.repository.entity.Medication;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicationMapper {

    List<MedicationModel> toModels(final List<Medication> medications);
}