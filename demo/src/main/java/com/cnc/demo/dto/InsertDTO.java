package com.cnc.demo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class InsertDTO {
    private Long id;
    private String brand;
    private String name;
    private String manufacturer;
    private String coating;
    private String material; // описание материала

    private BigDecimal cuttingEdgeStrength;

    private BigDecimal recommendedFeedMin;
    private BigDecimal recommendedFeedMax;

    private BigDecimal recommendedVcMin;
    private BigDecimal recommendedVcMax;

    private Set<Long> toolIds;
    private Set<Long> materialIds;
}
