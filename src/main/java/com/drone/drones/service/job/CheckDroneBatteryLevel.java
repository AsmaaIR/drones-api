package com.drone.drones.service.job;

import com.drone.drones.repository.DroneRepository;
import com.drone.drones.service.impl.DroneServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Component
@Slf4j
@Transactional
public class CheckDroneBatteryLevel {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired private DroneServiceImpl droneServiceImpl;

    @Value("${check.battery.level.job.enable}")
    boolean enableJob;

    @Scheduled(cron = "${check.battery.level.job}")
    public void checkDroneBatteryLevel() throws IOException {
        if (enableJob) {
            log.info("Start check drone battery level");
            droneServiceImpl.checkDroneBatteryLevel();
            log.info("check drone battery level job has been finished");
        }
    }
}