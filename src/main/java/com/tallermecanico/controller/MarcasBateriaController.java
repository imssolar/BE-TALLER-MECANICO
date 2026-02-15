package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateMarcasBateriaDto;
import com.tallermecanico.entity.MarcasBateria;
import com.tallermecanico.service.MarcasBateriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas-baterias")
public class MarcasBateriaController {

    private final MarcasBateriaService marcasBateriaService;

    public MarcasBateriaController(MarcasBateriaService marcasBateriaService) {
        this.marcasBateriaService = marcasBateriaService;
    }

    @PostMapping
    public ResponseEntity<MarcasBateria> create(@Valid @RequestBody CreateMarcasBateriaDto dto) {
        MarcasBateria marca = marcasBateriaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(marca);
    }

    @GetMapping
    public ResponseEntity<List<MarcasBateria>> findAll() {
        List<MarcasBateria> marcas = marcasBateriaService.findAll();
        return ResponseEntity.ok(marcas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcasBateria> findById(@PathVariable Integer id) {
        MarcasBateria marca = marcasBateriaService.findById(id);
        return ResponseEntity.ok(marca);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MarcasBateria> update(@PathVariable Integer id,
                                               @Valid @RequestBody CreateMarcasBateriaDto dto) {
        MarcasBateria marca = marcasBateriaService.update(id, dto);
        return ResponseEntity.ok(marca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        marcasBateriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
