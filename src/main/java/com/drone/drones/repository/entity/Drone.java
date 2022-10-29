package com.drone.drones.repository.entity;

import com.drone.drones.common.constant.ModelTypeEnum;
import com.drone.drones.common.constant.StateEnum;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "DRONES")
public class Drone {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "SERIAL_NUMBER")
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "DEVICE_TYPE")
    private ModelTypeEnum model;

    @Column(name = "WEIGHT")
    private double weight;

    @Column(name = "BATTERY_CAPACITY")
    private double batteryCapacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATE")
    private StateEnum state;

    @ToString.Exclude
    @OneToMany(mappedBy = "droneData", cascade = CascadeType.PERSIST)
    private List<Medication> medications;
}
