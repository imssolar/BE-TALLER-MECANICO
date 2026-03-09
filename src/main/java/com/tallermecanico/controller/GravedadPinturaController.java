package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateGravedadPinturaDto;
import com.tallermecanico.dto.request.UpdateGravedadPinturaDto;
import com.tallermecanico.dto.response.DeleteGravedadPinturaResponseDto;
import com.tallermecanico.entity.GravedadPintura;
import com.tallermecanico.service.GravedadPinturaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gravedad-pintura")
public class GravedadPinturaController {

    private final GravedadPinturaService gravedadPinturaService;

    public GravedadPinturaController(GravedadPinturaService gravedadPinturaService) {
        this.gravedadPinturaService = gravedadPinturaService;
    }

    @PostMapping
    public ResponseEntity<GravedadPintura> create(@Valid @RequestBody CreateGravedadPinturaDto dto) {
        GravedadPintura gravedadPintura = gravedadPinturaService.create(dto);
        return new ResponseEntity<>(gravedadPintura, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GravedadPintura>> findAll() {
        return ResponseEntity.ok(gravedadPinturaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GravedadPintura> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(gravedadPinturaService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GravedadPintura> update(@PathVariable Integer id,
                                                   @Valid @RequestBody UpdateGravedadPinturaDto dto) {
        return ResponseEntity.ok(gravedadPinturaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteGravedadPinturaResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(gravedadPinturaService.delete(id));
    }
}
