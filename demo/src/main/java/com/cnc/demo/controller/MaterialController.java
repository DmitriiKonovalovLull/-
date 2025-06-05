package com.cnc.demo.controller;

import com.cnc.demo.model.Material;
import com.cnc.demo.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Говорит Spring, что этот класс обрабатывает REST-запросы
@RequestMapping("/api/materials") // Базовый путь к контроллеру
public class MaterialController {

    private final MaterialRepository materialRepository;

    // Инъекция репозитория через конструктор
    @Autowired
    public MaterialController(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    // Получить все материалы: GET /api/materials
    @GetMapping
    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    // Получить материал по id: GET /api/materials/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Material> getMaterialById(@PathVariable Long id) {
        Optional<Material> material = materialRepository.findById(id);
        return material.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Добавить новый материал: POST /api/materials
    @PostMapping
    public Material createMaterial(@RequestBody Material material) {
        return materialRepository.save(material);
    }

    // Обновить существующий материал: PUT /api/materials/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Material> updateMaterial(@PathVariable Long id, @RequestBody Material updatedMaterial) {
        return materialRepository.findById(id)
                .map(existingMaterial -> {
                    existingMaterial.setName(updatedMaterial.getName());
                    existingMaterial.setDescription(updatedMaterial.getDescription());
                    materialRepository.save(existingMaterial);
                    return ResponseEntity.ok(existingMaterial);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Удалить материал: DELETE /api/materials/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        if (materialRepository.existsById(id)) {
            materialRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}
