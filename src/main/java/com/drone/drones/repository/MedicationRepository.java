package com.drone.drones.repository;

import com.drone.drones.repository.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository  extends JpaRepository<Medication, Long> {

    @Query("SELECT medication FROM Medication medication WHERE medication.id = ?1")
    List<Medication> findByDroneId(long id);
}