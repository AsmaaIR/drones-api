package com.drone.drones.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicationModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private double weight;

    private String code;

    private String imageUrl;
}