package com.drone.drones.repository;

import com.drone.drones.repository.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository  extends JpaRepository<Medication, Long> {

    List<Medication> findByDroneId(long id);
}
