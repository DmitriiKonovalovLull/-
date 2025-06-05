package com.cnc.demo.dto;
import lombok.Data;
import java.util.Set;


public class SetDiametrDTO {
    private Long id;
    private double diameter;
    private Set<Long> cuttingModesIds;
}
