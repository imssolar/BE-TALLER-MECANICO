package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateGravedadFibraDto;
import com.tallermecanico.dto.request.UpdateGravedadFibraDto;
import com.tallermecanico.dto.response.DeleteGravedadFibraResponseDto;
import com.tallermecanico.entity.GravedadFibra;
import com.tallermecanico.service.GravedadFibraService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gravedad-fibra")
public class GravedadFibraController {

    private final GravedadFibraService gravedadFibraService;

    public GravedadFibraController(GravedadFibraService gravedadFibraService) {
        this.gravedadFibraService = gravedadFibraService;
    }

    @PostMapping
    public ResponseEntity<GravedadFibra> create(@Valid @RequestBody CreateGravedadFibraDto dto) {
        GravedadFibra gravedadFibra = gravedadFibraService.create(dto);
        return new ResponseEntity<>(gravedadFibra, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GravedadFibra>> findAll() {
        return ResponseEntity.ok(gravedadFibraService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GravedadFibra> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(gravedadFibraService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GravedadFibra> update(@PathVariable Integer id,
                                                 @Valid @RequestBody UpdateGravedadFibraDto dto) {
        return ResponseEntity.ok(gravedadFibraService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteGravedadFibraResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(gravedadFibraService.delete(id));
    }
}
