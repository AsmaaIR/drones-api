package com.drone.drones.rest;

import com.drone.drones.common.DroneModel;
import com.drone.drones.common.MedicationModel;
import com.drone.drones.service.DroneService;
import com.drone.drones.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("drones")
public class DroneResource {

	@Autowired private DroneService droneService;
	@Autowired private MedicationService medicationService;

	@GetMapping
	List<DroneModel> findDrones() {
		return droneService.getDrones();
	}

	@PostMapping
	void registerDrone(@RequestBody @Valid DroneModel droneModel) throws ValidationException {
		droneService.registerDrone(droneModel);
	}

	@GetMapping("/available")
	List<DroneModel> getAvailableDroneForLoading(){
		return droneService.getAvailableDroneForLoading();
	}

	@GetMapping("{droneId}/battery-level")
	Double getBatteryLevelForDrone(@PathVariable("droneId")  long droneId){
		return droneService.getBatteryLevelForDrone(droneId);
	}


	@GetMapping("{droneId}/medications")
	List<MedicationModel> getMedicationsByDroneId(@PathVariable("droneId")  long droneId){
		return medicationService.getMedicationsByDroneId(droneId);
	}
}
