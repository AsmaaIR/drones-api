package com.drone.drones.service.impl;

import com.drone.drones.common.MedicationModel;
import com.drone.drones.repository.MedicationRepository;
import com.drone.drones.repository.entity.Medication;
import com.drone.drones.service.MedicationService;
import com.drone.drones.service.StorageService;
import com.drone.drones.service.mapper.MedicationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MedicationServiceImpl implements MedicationService {
    @Autowired private MedicationRepository medicationRepository;
    @Autowired private MedicationMapper medicationMapper;
    @Autowired private StorageService storageService;

     @Override
    public List<MedicationModel> getMedicationsByDroneId(long droneId) {
        List<Medication> medications =medicationRepository.findByDroneId(droneId);
        return medications
                .stream()
                .map(medicationMapper::toModel)
                .collect(Collectors.toList());
    }
}
