package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateGravedadCarroceriaDto;
import com.tallermecanico.dto.request.UpdateGravedadCarroceriaDto;
import com.tallermecanico.dto.response.DeleteGravedadCarroceriaResponseDto;
import com.tallermecanico.entity.GravedadCarroceria;
import com.tallermecanico.service.GravedadCarroceriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gravedad-carroceria")
public class GravedadCarroceriaController {

    private final GravedadCarroceriaService gravedadCarroceriaService;

    public GravedadCarroceriaController(GravedadCarroceriaService gravedadCarroceriaService) {
        this.gravedadCarroceriaService = gravedadCarroceriaService;
    }

    @PostMapping
    public ResponseEntity<GravedadCarroceria> create(@Valid @RequestBody CreateGravedadCarroceriaDto dto) {
        GravedadCarroceria gravedadCarroceria = gravedadCarroceriaService.create(dto);
        return new ResponseEntity<>(gravedadCarroceria, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GravedadCarroceria>> findAll() {
        return ResponseEntity.ok(gravedadCarroceriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GravedadCarroceria> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(gravedadCarroceriaService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GravedadCarroceria> update(@PathVariable Integer id,
                                                      @Valid @RequestBody UpdateGravedadCarroceriaDto dto) {
        return ResponseEntity.ok(gravedadCarroceriaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteGravedadCarroceriaResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(gravedadCarroceriaService.delete(id));
    }
}
