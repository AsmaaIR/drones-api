package com.drone.drones.repository.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MEDICATIONS")
public class Medication {

    @Id
    @SequenceGenerator(name = "MEDICATION_ID_GENERATOR", sequenceName = "MEDICATIONS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEDICATION_ID_GENERATOR")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "WEIGHT")
    private double weight;

    @Column(name = "CODE")
    private String code;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "DRONE_ID")
    private Drone droneData;
}