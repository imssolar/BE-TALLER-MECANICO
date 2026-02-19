package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateHerramientaDto;
import com.tallermecanico.dto.request.UpdateHerramientaDto;
import com.tallermecanico.dto.response.DeleteHerramientaResponseDto;
import com.tallermecanico.entity.Herramienta;
import com.tallermecanico.service.HerramientaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/herramientas")
public class HerramientaController {

    private final HerramientaService herramientaService;

    public HerramientaController(HerramientaService herramientaService) {
        this.herramientaService = herramientaService;
    }

    @PostMapping
    public ResponseEntity<Herramienta> create(@Valid @RequestBody CreateHerramientaDto dto) {
        Herramienta herramienta = herramientaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(herramienta);
    }

    @GetMapping
    public ResponseEntity<List<Herramienta>> findAll() {
        List<Herramienta> herramientas = herramientaService.findAll();
        return ResponseEntity.ok(herramientas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Herramienta> findById(@PathVariable Integer id) {
        Herramienta herramienta = herramientaService.findById(id);
        return ResponseEntity.ok(herramienta);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Herramienta> update(@PathVariable Integer id,
                                               @Valid @RequestBody UpdateHerramientaDto dto) {
        Herramienta herramienta = herramientaService.update(id, dto);
        return ResponseEntity.ok(herramienta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteHerramientaResponseDto> delete(@PathVariable Integer id) {
        DeleteHerramientaResponseDto response = herramientaService.delete(id);
        return ResponseEntity.ok(response);
    }
}
