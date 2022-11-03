package com.drone.drones.service.impl;

import com.drone.drones.common.DroneModel;
import com.drone.drones.common.MedicationModel;
import com.drone.drones.common.constant.StateEnum;
import com.drone.drones.repository.DroneRepository;
import com.drone.drones.repository.entity.Drone;
import com.drone.drones.service.DroneService;
import com.drone.drones.service.StorageService;
import com.drone.drones.service.mapper.DroneMapper;
import com.drone.drones.service.mapper.MedicationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DroneServiceImpl implements DroneService {
    private static final double MINIMUM_BATTERY_CAPACITY_FOR_LOADING = 25;
    private static final String FILE_EXTENSION = ".txt";
    private static final String FILE_NAME = "logs/" + "log"+ FILE_EXTENSION;
    @Autowired
    private DroneRepository droneRepository;
    @Autowired
    private DroneMapper droneMapper;
    @Autowired
    private MedicationMapper medicationMapper;
    @Autowired
    private StorageService storageService;
    @Autowired
    private StorageServiceImpl storageServiceImpl;


    @Override
    public void registerDrone(DroneModel droneModel) throws ValidationException {
        log.info("register drone");
        if (droneModel.getBatteryCapacity() < MINIMUM_BATTERY_CAPACITY_FOR_LOADING && StateEnum.LOADING.name().equals(droneModel.getState())) {
            throw new ValidationException("the drone Can't be loading, Battery is low");
        }

        AtomicReference<Double> loadedWeight = new AtomicReference<>((double) 0);
        if (droneModel.getMedications() != null && !droneModel.getMedications().isEmpty()) {
            droneModel.getMedications().forEach(medicationModel -> {
                if (medicationModel.getImage() != null) {
                    String imageUri = saveMedicationImage(medicationModel, droneModel.getSerialNumber());
                    medicationModel.setImageUrl(imageUri);
                    loadedWeight.updateAndGet(v -> (v + medicationModel.getWeight()));
                }
            });
        }

        if(loadedWeight.get() > 500){
            throw new ValidationException("the drone Can't be loading, over wight");
        }

        droneModel.setWeight(loadedWeight.get());
        Drone drone = droneMapper.toEntity(droneModel);
        Drone finalDrone = drone;
        drone.getMedications().forEach(medication -> medication.setDroneData(finalDrone));
        drone = droneRepository.save(drone);

        log.info("drone created successfully {}", drone);

    }

    @Override
    public List<DroneModel> getDrones() {
        log.info("getDrones::find all drones");
        List<Drone> drones = droneRepository.getAllDrones();
        return drones.stream()
                .map(droneMapper::toModel)
                .collect(Collectors.toList());
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

    public String saveMedicationImage(MedicationModel medicationModel, String serialNumber) {
        log.debug("Save Medication image for drone with serial Number {}", serialNumber);
        String[] directory = {serialNumber, String.valueOf(new Date().getTime())};
        try {
            return storageService.saveImage(medicationModel.getImage(), directory);
        } catch (IOException e) {
            log.error("Couldn't save image {}", directory, e);
        }
        return null;
    }

    public void checkDroneBatteryLevel() throws IOException {
        List<DroneModel> drones = getDrones();
        createLogDirectory();
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(FILE_NAME);
        FileWriter fr = new FileWriter(file, true);
        stringBuilder.append("###########").append(new Date()).append("###########").append("\n");
        fr.write(stringBuilder.toString());
        stringBuilder.setLength(0);
        drones.forEach(droneModel -> stringBuilder
                .append("The Battery Level for drone with id: ")
                .append(droneModel.getId()).append(" and serial number: ")
                .append(droneModel.getSerialNumber())
                .append(" is: ").append(droneModel.getBatteryCapacity()).append("\n"));
        fr.write(stringBuilder.toString());
        fr.close();
    }

    public void createLogDirectory() {
        String[] directory = {};
        storageServiceImpl.createDirectory(directory, "logs/");
    }
}