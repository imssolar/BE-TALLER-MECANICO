package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateIncidenciaDto;
import com.tallermecanico.dto.request.UpdateIncidenciaDto;
import com.tallermecanico.dto.response.DeleteIncidenciaResponseDto;
import com.tallermecanico.entity.Incidencia;
import com.tallermecanico.service.IncidenciaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incidencias")
public class IncidenciaController {

    private final IncidenciaService incidenciaService;

    public IncidenciaController(IncidenciaService incidenciaService) {
        this.incidenciaService = incidenciaService;
    }

    @PostMapping
    public ResponseEntity<Incidencia> create(@Valid @RequestBody CreateIncidenciaDto dto) {
        Incidencia incidencia = incidenciaService.create(dto);
        return new ResponseEntity<>(incidencia, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Incidencia>> findAll() {
        return ResponseEntity.ok(incidenciaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incidencia> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(incidenciaService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Incidencia> update(@PathVariable Integer id,
                                              @Valid @RequestBody UpdateIncidenciaDto dto) {
        return ResponseEntity.ok(incidenciaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteIncidenciaResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(incidenciaService.delete(id));
    }
}
