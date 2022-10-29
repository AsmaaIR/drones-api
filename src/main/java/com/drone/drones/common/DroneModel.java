package com.drone.drones.common;

import com.drone.drones.common.constant.ModelTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DroneModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String serialNumber;

    private ModelTypeEnum model;

    private double weight;

    private double batteryCapacity;

    private String state;

    private List<MedicationModel> medications;
}