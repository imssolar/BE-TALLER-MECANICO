package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateEquipamientoDto;
import com.tallermecanico.dto.request.UpdateEquipamientoDto;
import com.tallermecanico.dto.response.DeleteEquipamientoResponseDto;
import com.tallermecanico.entity.Equipamiento;
import com.tallermecanico.service.EquipamientoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamiento")
public class EquipamientoController {

    private final EquipamientoService equipamientoService;

    public EquipamientoController(EquipamientoService equipamientoService) {
        this.equipamientoService = equipamientoService;
    }

    @PostMapping
    public ResponseEntity<Equipamiento> create(@Valid @RequestBody CreateEquipamientoDto dto) {
        Equipamiento equipamiento = equipamientoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(equipamiento);
    }

    @GetMapping
    public ResponseEntity<List<Equipamiento>> findAll() {
        List<Equipamiento> equipamientos = equipamientoService.findAll();
        return ResponseEntity.ok(equipamientos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipamiento> findById(@PathVariable Integer id) {
        Equipamiento equipamiento = equipamientoService.findById(id);
        return ResponseEntity.ok(equipamiento);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Equipamiento> update(@PathVariable Integer id,
                                               @Valid @RequestBody UpdateEquipamientoDto dto) {
        Equipamiento equipamiento = equipamientoService.update(id, dto);
        return ResponseEntity.ok(equipamiento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteEquipamientoResponseDto> delete(@PathVariable Integer id) {
        DeleteEquipamientoResponseDto response = equipamientoService.delete(id);
        return ResponseEntity.ok(response);
    }
}
