package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateDetalleCapDto;
import com.tallermecanico.dto.request.UpdateDetalleCapDto;
import com.tallermecanico.dto.response.DeleteDetalleCapResponseDto;
import com.tallermecanico.entity.DetalleCap;
import com.tallermecanico.service.DetalleCapService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-cap")
public class DetalleCapController {

    private final DetalleCapService detalleCapService;

    public DetalleCapController(DetalleCapService detalleCapService) {
        this.detalleCapService = detalleCapService;
    }

    @PostMapping
    public ResponseEntity<DetalleCap> create(@Valid @RequestBody CreateDetalleCapDto dto) {
        DetalleCap detalle = detalleCapService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalle);
    }

    @GetMapping
    public ResponseEntity<List<DetalleCap>> findAll() {
        List<DetalleCap> detalles = detalleCapService.findAll();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleCap> findById(@PathVariable Integer id) {
        DetalleCap detalle = detalleCapService.findById(id);
        return ResponseEntity.ok(detalle);
    }

    @GetMapping("/capacitacion/{idCapacitacion}")
    public ResponseEntity<List<DetalleCap>> findByCapacitacion(@PathVariable Integer idCapacitacion) {
        List<DetalleCap> detalles = detalleCapService.findByCapacitacion(idCapacitacion);
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/run/{run}")
    public ResponseEntity<List<DetalleCap>> findByRun(@PathVariable String run) {
        List<DetalleCap> detalles = detalleCapService.findByRun(run);
        return ResponseEntity.ok(detalles);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DetalleCap> update(@PathVariable Integer id,
                                              @Valid @RequestBody UpdateDetalleCapDto dto) {
        DetalleCap detalle = detalleCapService.update(id, dto);
        return ResponseEntity.ok(detalle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteDetalleCapResponseDto> delete(@PathVariable Integer id) {
        DeleteDetalleCapResponseDto response = detalleCapService.delete(id);
        return ResponseEntity.ok(response);
    }
}
