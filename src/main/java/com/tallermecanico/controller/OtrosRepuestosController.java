package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateOtrosRepuestosDto;
import com.tallermecanico.dto.request.UpdateOtrosRepuestosDto;
import com.tallermecanico.dto.response.DeleteOtrosRepuestosResponseDto;
import com.tallermecanico.entity.OtrosRepuestos;
import com.tallermecanico.service.OtrosRepuestosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/otros-repuestos")
public class OtrosRepuestosController {

    private final OtrosRepuestosService otrosRepuestosService;

    public OtrosRepuestosController(OtrosRepuestosService otrosRepuestosService) {
        this.otrosRepuestosService = otrosRepuestosService;
    }

    @PostMapping
    public ResponseEntity<OtrosRepuestos> create(@Valid @RequestBody CreateOtrosRepuestosDto dto) {
        OtrosRepuestos otrosRepuestos = otrosRepuestosService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(otrosRepuestos);
    }

    @GetMapping
    public ResponseEntity<List<OtrosRepuestos>> findAll() {
        List<OtrosRepuestos> otrosRepuestos = otrosRepuestosService.findAll();
        return ResponseEntity.ok(otrosRepuestos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OtrosRepuestos> findById(@PathVariable Integer id) {
        OtrosRepuestos otrosRepuestos = otrosRepuestosService.findById(id);
        return ResponseEntity.ok(otrosRepuestos);
    }

    @GetMapping("/orden-trabajo/{idOrdenTrabajo}")
    public ResponseEntity<List<OtrosRepuestos>> findByOrdenTrabajo(@PathVariable Integer idOrdenTrabajo) {
        List<OtrosRepuestos> otrosRepuestos = otrosRepuestosService.findByOrdenTrabajo(idOrdenTrabajo);
        return ResponseEntity.ok(otrosRepuestos);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OtrosRepuestos> update(@PathVariable Integer id,
                                                  @Valid @RequestBody UpdateOtrosRepuestosDto dto) {
        OtrosRepuestos otrosRepuestos = otrosRepuestosService.update(id, dto);
        return ResponseEntity.ok(otrosRepuestos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOtrosRepuestosResponseDto> delete(@PathVariable Integer id) {
        DeleteOtrosRepuestosResponseDto response = otrosRepuestosService.delete(id);
        return ResponseEntity.ok(response);
    }
}
