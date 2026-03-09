package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateRepuestosProyectadosDto;
import com.tallermecanico.dto.request.UpdateRepuestosProyectadosDto;
import com.tallermecanico.dto.response.DeleteRepuestosProyectadosResponseDto;
import com.tallermecanico.entity.RepuestosProyectados;
import com.tallermecanico.service.RepuestosProyectadosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repuestos-proyectados")
public class RepuestosProyectadosController {

    private final RepuestosProyectadosService repuestosProyectadosService;

    public RepuestosProyectadosController(RepuestosProyectadosService repuestosProyectadosService) {
        this.repuestosProyectadosService = repuestosProyectadosService;
    }

    @PostMapping
    public ResponseEntity<RepuestosProyectados> create(@Valid @RequestBody CreateRepuestosProyectadosDto dto) {
        RepuestosProyectados repuestosProyectados = repuestosProyectadosService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(repuestosProyectados);
    }

    @GetMapping
    public ResponseEntity<List<RepuestosProyectados>> findAll() {
        List<RepuestosProyectados> repuestosProyectados = repuestosProyectadosService.findAll();
        return ResponseEntity.ok(repuestosProyectados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepuestosProyectados> findById(@PathVariable Integer id) {
        RepuestosProyectados repuestosProyectados = repuestosProyectadosService.findById(id);
        return ResponseEntity.ok(repuestosProyectados);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RepuestosProyectados> update(@PathVariable Integer id,
                                                       @Valid @RequestBody UpdateRepuestosProyectadosDto dto) {
        RepuestosProyectados repuestosProyectados = repuestosProyectadosService.update(id, dto);
        return ResponseEntity.ok(repuestosProyectados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteRepuestosProyectadosResponseDto> delete(@PathVariable Integer id) {
        DeleteRepuestosProyectadosResponseDto response = repuestosProyectadosService.delete(id);
        return ResponseEntity.ok(response);
    }
}
