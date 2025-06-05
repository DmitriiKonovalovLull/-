package com.cnc.demo.mapper;

import com.cnc.demo.dto.InsertDTO;
import com.cnc.demo.model.Insert;
import com.cnc.demo.model.Material;
import com.cnc.demo.model.Tool;
import java.util.Set;
import java.util.stream.Collectors;

public class InsertMapper {

    public static InsertDTO toDTO(Insert insert) {
        if (insert == null) {
            return null;
        }

        InsertDTO dto = new InsertDTO();
        dto.setId(insert.getId());
        dto.setName(insert.getName());
        dto.setBrand(insert.getBrand());
        dto.setManufacturer(insert.getManufacturer());
        dto.setCoating(insert.getCoating());
        dto.setMaterial(insert.getMaterial());
        dto.setCuttingEdgeStrength(insert.getCuttingEdgeStrength());
        dto.setRecommendedFeedMin(insert.getRecommendedFeedMin());
        dto.setRecommendedFeedMax(insert.getRecommendedFeedMax());
        dto.setRecommendedVcMin(insert.getRecommendedVcMin());
        dto.setRecommendedVcMax(insert.getRecommendedVcMax());

        if (insert.getTools() != null) {
            dto.setToolIds(insert.getTools().stream()
                    .map(Tool::getId)
                    .collect(Collectors.toSet()));
        }

        if (insert.getMaterials() != null) {
            dto.setMaterialIds(insert.getMaterials().stream()
                    .map(Material::getId)
                    .collect(Collectors.toSet()));
        }

        return dto;
    }

    public static Insert toEntity(InsertDTO dto, Set<Tool> tools, Set<Material> materials) {
        if (dto == null) {
            return null;
        }

        Insert insert = new Insert();
        insert.setId(dto.getId());
        insert.setName(dto.getName());
        insert.setBrand(dto.getBrand());
        insert.setManufacturer(dto.getManufacturer());
        insert.setCoating(dto.getCoating());
        insert.setMaterial(dto.getMaterial());
        insert.setCuttingEdgeStrength(dto.getCuttingEdgeStrength());
        insert.setRecommendedFeedMin(dto.getRecommendedFeedMin());
        insert.setRecommendedFeedMax(dto.getRecommendedFeedMax());
        insert.setRecommendedVcMin(dto.getRecommendedVcMin());
        insert.setRecommendedVcMax(dto.getRecommendedVcMax());

        insert.setTools(tools);
        insert.setMaterials(materials);

        return insert;
    }
}
