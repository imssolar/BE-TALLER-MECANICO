package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateDetalleEntregaDto;
import com.tallermecanico.dto.request.UpdateDetalleEntregaDto;
import com.tallermecanico.dto.response.DeleteDetalleEntregaResponseDto;
import com.tallermecanico.entity.DetalleEntrega;
import com.tallermecanico.service.DetalleEntregaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-entregas")
public class DetalleEntregaController {

    private final DetalleEntregaService detalleEntregaService;

    public DetalleEntregaController(DetalleEntregaService detalleEntregaService) {
        this.detalleEntregaService = detalleEntregaService;
    }

    @PostMapping
    public ResponseEntity<DetalleEntrega> create(@Valid @RequestBody CreateDetalleEntregaDto dto) {
        DetalleEntrega detalle = detalleEntregaService.create(dto);
        return new ResponseEntity<>(detalle, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DetalleEntrega>> findAll() {
        return ResponseEntity.ok(detalleEntregaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleEntrega> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(detalleEntregaService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DetalleEntrega> update(@PathVariable Integer id,
                                                  @Valid @RequestBody UpdateDetalleEntregaDto dto) {
        return ResponseEntity.ok(detalleEntregaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteDetalleEntregaResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(detalleEntregaService.delete(id));
    }
}
