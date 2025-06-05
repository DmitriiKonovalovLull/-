package com.cnc.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "set_diameters")
public class SetDiametr {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "diameter", nullable = false)
    private double diameter;

    @ManyToMany(mappedBy = "setDiameters")
    private Set<CuttingMode> cuttingModes;
}
