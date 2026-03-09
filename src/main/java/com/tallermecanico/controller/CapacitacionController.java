package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateCapacitacionDto;
import com.tallermecanico.dto.request.UpdateCapacitacionDto;
import com.tallermecanico.dto.response.DeleteCapacitacionResponseDto;
import com.tallermecanico.entity.Capacitacion;
import com.tallermecanico.service.CapacitacionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capacitaciones")
public class CapacitacionController {

    private final CapacitacionService capacitacionService;

    public CapacitacionController(CapacitacionService capacitacionService) {
        this.capacitacionService = capacitacionService;
    }

    @PostMapping
    public ResponseEntity<Capacitacion> create(@Valid @RequestBody CreateCapacitacionDto dto) {
        Capacitacion capacitacion = capacitacionService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(capacitacion);
    }

    @GetMapping
    public ResponseEntity<List<Capacitacion>> findAll() {
        List<Capacitacion> capacitaciones = capacitacionService.findAll();
        return ResponseEntity.ok(capacitaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Capacitacion> findById(@PathVariable Integer id) {
        Capacitacion capacitacion = capacitacionService.findById(id);
        return ResponseEntity.ok(capacitacion);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Capacitacion> update(@PathVariable Integer id,
                                                @Valid @RequestBody UpdateCapacitacionDto dto) {
        Capacitacion capacitacion = capacitacionService.update(id, dto);
        return ResponseEntity.ok(capacitacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCapacitacionResponseDto> delete(@PathVariable Integer id) {
        DeleteCapacitacionResponseDto response = capacitacionService.delete(id);
        return ResponseEntity.ok(response);
    }
}
