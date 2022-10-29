package com.drone.drones.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicationModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @Pattern(regexp = "^[A-Za-z0-9_-]*$", message = "INVALID_NAME")
    private String name;

    private double weight;

    @Pattern(regexp = "^[A-Z0-9_]*$", message = "INVALID_CODE")
    private String code;

    private String imageUrl;
}