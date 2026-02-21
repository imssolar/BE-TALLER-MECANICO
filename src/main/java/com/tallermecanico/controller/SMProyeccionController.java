package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateSMProyeccionDto;
import com.tallermecanico.dto.request.UpdateSMProyeccionDto;
import com.tallermecanico.dto.response.DeleteSMProyeccionResponseDto;
import com.tallermecanico.entity.SMProyeccion;
import com.tallermecanico.service.SMProyeccionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sm-proyeccion")
public class SMProyeccionController {

    private final SMProyeccionService smProyeccionService;

    public SMProyeccionController(SMProyeccionService smProyeccionService) {
        this.smProyeccionService = smProyeccionService;
    }

    @PostMapping
    public ResponseEntity<SMProyeccion> create(@Valid @RequestBody CreateSMProyeccionDto dto) {
        SMProyeccion smProyeccion = smProyeccionService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(smProyeccion);
    }

    @GetMapping
    public ResponseEntity<List<SMProyeccion>> findAll() {
        List<SMProyeccion> proyecciones = smProyeccionService.findAll();
        return ResponseEntity.ok(proyecciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SMProyeccion> findById(@PathVariable Integer id) {
        SMProyeccion smProyeccion = smProyeccionService.findById(id);
        return ResponseEntity.ok(smProyeccion);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SMProyeccion> update(@PathVariable Integer id,
                                                @Valid @RequestBody UpdateSMProyeccionDto dto) {
        SMProyeccion smProyeccion = smProyeccionService.update(id, dto);
        return ResponseEntity.ok(smProyeccion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteSMProyeccionResponseDto> delete(@PathVariable Integer id) {
        DeleteSMProyeccionResponseDto response = smProyeccionService.delete(id);
        return ResponseEntity.ok(response);
    }
}
