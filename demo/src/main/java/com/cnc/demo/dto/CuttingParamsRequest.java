package com.cnc.demo.dto;

import lombok.Data;

@Data
public class CuttingParamsRequest {
    private double diameter;
    private Long materialId;
}
