package com.cnc.demo.dto;

import lombok.Data;
import java.util.Set;

@Data
public class ToolDTO {
    private Long id;
    private String name;
    private Set<Long> cuttingModesIds;
}
