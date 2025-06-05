package com.cnc.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuttingParamsResponse {
    private double cuttingSpeed;
    private double spindleSpeed;
    private double feedRate;
    private double depthOfCut;
}
