package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateMantencionDto;
import com.tallermecanico.dto.request.UpdateMantencionDto;
import com.tallermecanico.dto.response.DeleteMantencionResponseDto;
import com.tallermecanico.entity.Mantencion;
import com.tallermecanico.service.MantencionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mantenciones")
public class MantencionController {

    private final MantencionService mantencionService;

    public MantencionController(MantencionService mantencionService) {
        this.mantencionService = mantencionService;
    }

    @PostMapping
    public ResponseEntity<Mantencion> create(@Valid @RequestBody CreateMantencionDto dto) {
        Mantencion mantencion = mantencionService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mantencion);
    }

    @GetMapping
    public ResponseEntity<List<Mantencion>> findAll() {
        List<Mantencion> mantenciones = mantencionService.findAll();
        return ResponseEntity.ok(mantenciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mantencion> findById(@PathVariable Integer id) {
        Mantencion mantencion = mantencionService.findById(id);
        return ResponseEntity.ok(mantencion);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Mantencion> update(@PathVariable Integer id,
                                              @Valid @RequestBody UpdateMantencionDto dto) {
        Mantencion mantencion = mantencionService.update(id, dto);
        return ResponseEntity.ok(mantencion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMantencionResponseDto> delete(@PathVariable Integer id) {
        DeleteMantencionResponseDto response = mantencionService.delete(id);
        return ResponseEntity.ok(response);
    }
}
