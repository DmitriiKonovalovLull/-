package com.cnc.demo.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CuttingModeDTO {

    private Long id;
    private double cuttingSpeed;
    private double feed;
    private double depth;
    private Double spindleSpeed;

    private Set<Long> materialIds;
    private Set<Long> toolIds;
    private Set<Long> setDiameterIds;

}
