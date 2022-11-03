package com.drone.drones.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DroneModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @Size(max = 100, message = "{SERIAL_NUMBER_SIZE_TOO_LONG}")
    private String serialNumber;

    private String model;

    @Max(value=500, message = "WEIGHT_EXCEED_MAX_LENGTH")
    private double weight;

    private double batteryCapacity;

    private String state;

    @ToString.Exclude
    private List<MedicationModel> medications;
}