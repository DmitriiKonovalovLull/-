package com.cnc.demo.service;

import com.cnc.demo.model.CuttingMode;
import com.cnc.demo.model.Material;
import com.cnc.demo.repository.CuttingModeRepository;
import com.cnc.demo.repository.MaterialRepository;
import org.springframework.stereotype.Service;

@Service
public class CuttingModeService {

    private final CuttingModeRepository cuttingModeRepository;
    private final MaterialRepository materialRepository;

    public CuttingModeService(CuttingModeRepository cuttingModeRepository,
                              MaterialRepository materialRepository) {
        this.cuttingModeRepository = cuttingModeRepository;
        this.materialRepository = materialRepository;
    }

    public CuttingMode calculateCuttingMode(Long materialId, Double diameter) {
        Material material = materialRepository.findById(materialId)
                .orElseThrow(() -> new RuntimeException("Материал не найден"));

        double cuttingSpeed = material.getCuttingSpeed();
        double spindleSpeed = (cuttingSpeed * 1000) / (Math.PI * diameter);

        CuttingMode cuttingMode = new CuttingMode();
        cuttingMode.setDiameter(diameter);
        cuttingMode.setCuttingSpeed(cuttingSpeed);
        cuttingMode.setSpindleSpeed(spindleSpeed);

        return cuttingModeRepository.save(cuttingMode);
    }
}
