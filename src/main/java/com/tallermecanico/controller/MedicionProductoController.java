package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateMedicionProductoDto;
import com.tallermecanico.dto.request.UpdateMedicionProductoDto;
import com.tallermecanico.dto.response.DeleteMedicionProductoResponseDto;
import com.tallermecanico.entity.MedicionProducto;
import com.tallermecanico.service.MedicionProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicion-productos")
public class MedicionProductoController {

    private final MedicionProductoService medicionProductoService;

    public MedicionProductoController(MedicionProductoService medicionProductoService) {
        this.medicionProductoService = medicionProductoService;
    }

    @PostMapping
    public ResponseEntity<MedicionProducto> create(@Valid @RequestBody CreateMedicionProductoDto dto) {
        MedicionProducto medicionProducto = medicionProductoService.create(dto);
        return new ResponseEntity<>(medicionProducto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MedicionProducto>> findAll() {
        return ResponseEntity.ok(medicionProductoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicionProducto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(medicionProductoService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MedicionProducto> update(@PathVariable Integer id,
                                                    @Valid @RequestBody UpdateMedicionProductoDto dto) {
        return ResponseEntity.ok(medicionProductoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMedicionProductoResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(medicionProductoService.delete(id));
    }
}
