package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateFallasTiposDto;
import com.tallermecanico.dto.request.UpdateFallasTiposDto;
import com.tallermecanico.entity.FallasTipos;
import com.tallermecanico.service.FallasTiposService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fallas-tipos")
public class FallasTiposController {

    private final FallasTiposService fallasTiposService;

    public FallasTiposController(FallasTiposService fallasTiposService) {
        this.fallasTiposService = fallasTiposService;
    }

    @PostMapping
    public ResponseEntity<FallasTipos> create(@Valid @RequestBody CreateFallasTiposDto dto) {
        FallasTipos fallasTipos = fallasTiposService.create(dto);
        return ResponseEntity.status(201).body(fallasTipos);
    }

    @GetMapping
    public List<FallasTipos> getAll() {
        return fallasTiposService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FallasTipos> getById(@PathVariable Integer id) {
        FallasTipos fallasTipos = fallasTiposService.findById(id);
        return ResponseEntity.ok(fallasTipos);
    }

    @GetMapping("/falla/{idFalla}")
    public List<FallasTipos> getByFalla(@PathVariable String idFalla) {
        return fallasTiposService.findByFalla(idFalla);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FallasTipos> update(@PathVariable Integer id, @Valid @RequestBody UpdateFallasTiposDto dto) {
        FallasTipos fallasTipos = fallasTiposService.update(id, dto);
        return ResponseEntity.ok(fallasTipos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        fallasTiposService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
