package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateEstadosNeumaticoDto;
import com.tallermecanico.dto.request.UpdateEstadosNeumaticoDto;
import com.tallermecanico.dto.response.DeleteEstadosNeumaticoResponseDto;
import com.tallermecanico.entity.EstadosNeumatico;
import com.tallermecanico.service.EstadosNeumaticoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados-neumatico")
public class EstadosNeumaticoController {

    private final EstadosNeumaticoService estadosNeumaticoService;

    public EstadosNeumaticoController(EstadosNeumaticoService estadosNeumaticoService) {
        this.estadosNeumaticoService = estadosNeumaticoService;
    }

    @PostMapping
    public ResponseEntity<EstadosNeumatico> create(@Valid @RequestBody CreateEstadosNeumaticoDto dto) {
        EstadosNeumatico estado = estadosNeumaticoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(estado);
    }

    @GetMapping
    public ResponseEntity<List<EstadosNeumatico>> findAll() {
        List<EstadosNeumatico> estados = estadosNeumaticoService.findAll();
        return ResponseEntity.ok(estados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadosNeumatico> findById(@PathVariable Integer id) {
        EstadosNeumatico estado = estadosNeumaticoService.findById(id);
        return ResponseEntity.ok(estado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EstadosNeumatico> update(@PathVariable Integer id,
                                                   @Valid @RequestBody UpdateEstadosNeumaticoDto dto) {
        EstadosNeumatico estado = estadosNeumaticoService.update(id, dto);
        return ResponseEntity.ok(estado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteEstadosNeumaticoResponseDto> delete(@PathVariable Integer id) {
        DeleteEstadosNeumaticoResponseDto response = estadosNeumaticoService.delete(id);
        return ResponseEntity.ok(response);
    }
}
