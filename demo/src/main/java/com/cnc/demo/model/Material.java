package com.cnc.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "materials")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "materials")
    private Set<CuttingMode> cuttingModes;

    @Column(name = "cutting_speed")
    private Double cuttingSpeed;

    @Column(name = "description")
    private String description;

}
