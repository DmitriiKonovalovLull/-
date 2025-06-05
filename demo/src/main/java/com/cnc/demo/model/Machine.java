package com.cnc.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "machines")
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "com/cnc/demo/model")
    private String model;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "max_rpm")
    private int maxRpm;
    @Column (name = "max_power")
    private int maxPower;

}
