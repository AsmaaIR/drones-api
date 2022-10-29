package com.drone.drones.service.impl;

import com.drone.drones.common.MedicationModel;
import com.drone.drones.repository.MedicationRepository;
import com.drone.drones.service.MedicationService;
import com.drone.drones.service.mapper.MedicationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MedicationServiceImpl implements MedicationService {
    @Autowired private MedicationRepository medicationRepository;
    @Autowired private MedicationMapper medicationMapper;

    @Override
    public List<MedicationModel> getMedicationsByDroneId(long droneId) {
        return medicationMapper.toModels(medicationRepository.findByDroneId(droneId));
    }
}
