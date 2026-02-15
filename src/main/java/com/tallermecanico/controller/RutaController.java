package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateRutaDto;
import com.tallermecanico.dto.request.UpdateRutaDto;
import com.tallermecanico.dto.response.DeleteResponseDto;
import com.tallermecanico.dto.response.RutaResponseDto;
import com.tallermecanico.service.RutaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rutas")
public class RutaController {

    private final RutaService rutaService;

    public RutaController(RutaService rutaService) {
        this.rutaService = rutaService;
    }

    @PostMapping
    public ResponseEntity<RutaResponseDto> create(@Valid @RequestBody CreateRutaDto dto) {
        RutaResponseDto ruta = rutaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ruta);
    }

    @GetMapping
    public ResponseEntity<List<RutaResponseDto>> findAll() {
        List<RutaResponseDto> rutas = rutaService.findAll();
        return ResponseEntity.ok(rutas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutaResponseDto> findById(@PathVariable Integer id) {
        RutaResponseDto ruta = rutaService.findById(id);
        return ResponseEntity.ok(ruta);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RutaResponseDto> update(@PathVariable Integer id,
                                                  @Valid @RequestBody UpdateRutaDto dto) {
        RutaResponseDto ruta = rutaService.update(id, dto);
        return ResponseEntity.ok(ruta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteResponseDto> delete(@PathVariable Integer id) {
        DeleteResponseDto response = rutaService.delete(id);
        return ResponseEntity.ok(response);
    }
}
