package com.cnc.demo.dto;
import com.cnc.demo.model.CuttingMode;
import lombok.Data;

import java.util.Set;

@Data
public class MaterialDTO {
    private Long id;
    private String name;
    private String description;
    private Double cuttingSpeedIds;
    private Set<Long> cuttingModesIds;

}

