package com.drone.drones.repository;

import com.drone.drones.repository.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {

    @Query("SELECT drone FROM Drone drone left Join Medication med on drone.id = med.droneData.id ")
    List<Drone> getAllDrones();

    @Query("SELECT drone FROM Drone drone WHERE drone.batteryCapacity > 25 And drone.state ='IDLE'")
    List<Drone> getAvailableDrones();

    @Query("SELECT drone.batteryCapacity FROM Drone drone WHERE drone.id = ?1")
    Double getDroneBatteryLevel(long id);
}