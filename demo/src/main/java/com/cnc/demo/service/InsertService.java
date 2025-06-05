package com.cnc.demo.service;

import com.cnc.demo.dto.InsertDTO;
import com.cnc.demo.mapper.InsertMapper;
import com.cnc.demo.model.Insert;
import com.cnc.demo.model.Material;
import com.cnc.demo.model.Tool;
import com.cnc.demo.repository.InsertRepository;
import com.cnc.demo.repository.MaterialRepository;
import com.cnc.demo.repository.ToolRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class InsertService {

    private final InsertRepository insertRepository;
    private final ToolRepository toolRepository;
    private final MaterialRepository materialRepository;

    public InsertService(InsertRepository insertRepository,
                         ToolRepository toolRepository,
                         MaterialRepository materialRepository) {
        this.insertRepository = insertRepository;
        this.toolRepository = toolRepository;
        this.materialRepository = materialRepository;
    }

    public InsertDTO save(InsertDTO insertDTO) {
        Set<Tool> tools = new HashSet<>();
        if (insertDTO.getToolIds() != null) {
            tools = insertDTO.getToolIds().stream()
                    .map(toolRepository::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toSet());
        }

        Set<Material> materials = new HashSet<>();
        if (insertDTO.getMaterialIds() != null) {
            materials = insertDTO.getMaterialIds().stream()
                    .map(materialRepository::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toSet());
        }

        Insert insert = InsertMapper.toEntity(insertDTO, tools, materials);
        Insert saved = insertRepository.save(insert);
        return InsertMapper.toDTO(saved);
    }

    public List<InsertDTO> findAll() {
        return insertRepository.findAll().stream()
                .map(InsertMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<InsertDTO> findById(Long id) {
        return insertRepository.findById(id)
                .map(InsertMapper::toDTO);
    }

    public void deleteById(Long id) {
        insertRepository.deleteById(id);
    }
}
