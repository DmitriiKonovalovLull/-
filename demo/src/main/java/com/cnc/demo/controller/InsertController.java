package com.cnc.demo.controller;

import com.cnc.demo.dto.InsertDTO;
import com.cnc.demo.service.InsertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inserts")
public class InsertController {

    private final InsertService insertService;

    public InsertController(InsertService insertService) {
        this.insertService = insertService;
    }

    @GetMapping
    public List<InsertDTO> getAll() {
        return insertService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsertDTO> getById(@PathVariable Long id) {
        return insertService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public InsertDTO create(@RequestBody InsertDTO insertDTO) {
        return insertService.save(insertDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsertDTO> update(@PathVariable Long id, @RequestBody InsertDTO insertDTO) {
        if (!insertService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        insertDTO.setId(id);
        InsertDTO updated = insertService.save(insertDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!insertService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        insertService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
