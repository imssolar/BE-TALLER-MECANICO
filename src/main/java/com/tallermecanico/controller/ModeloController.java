package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateModeloDto;
import com.tallermecanico.dto.request.UpdateModeloDto;
import com.tallermecanico.dto.response.DeleteModeloResponseDto;
import com.tallermecanico.entity.Modelo;
import com.tallermecanico.service.ModeloService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    private final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @PostMapping
    public ResponseEntity<Modelo> create(@Valid @RequestBody CreateModeloDto dto) {
        Modelo modelo = modeloService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelo);
    }

    @GetMapping
    public ResponseEntity<List<Modelo>> findAll() {
        List<Modelo> modelos = modeloService.findAll();
        return ResponseEntity.ok(modelos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> findById(@PathVariable Integer id) {
        Modelo modelo = modeloService.findById(id);
        return ResponseEntity.ok(modelo);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Modelo> update(@PathVariable Integer id,
                                          @Valid @RequestBody UpdateModeloDto dto) {
        Modelo modelo = modeloService.update(id, dto);
        return ResponseEntity.ok(modelo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteModeloResponseDto> delete(@PathVariable Integer id) {
        DeleteModeloResponseDto response = modeloService.delete(id);
        return ResponseEntity.ok(response);
    }
}
