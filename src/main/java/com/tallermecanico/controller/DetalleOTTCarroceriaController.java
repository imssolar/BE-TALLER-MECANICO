package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateDetalleOTTCarroceriaDto;
import com.tallermecanico.dto.request.UpdateDetalleOTTCarroceriaDto;
import com.tallermecanico.dto.response.DeleteDetalleOTTCarroceriaResponseDto;
import com.tallermecanico.entity.DetalleOTTCarroceria;
import com.tallermecanico.service.DetalleOTTCarroceriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-ott-carroceria")
public class DetalleOTTCarroceriaController {

    private final DetalleOTTCarroceriaService detalleOTTCarroceriaService;

    public DetalleOTTCarroceriaController(DetalleOTTCarroceriaService detalleOTTCarroceriaService) {
        this.detalleOTTCarroceriaService = detalleOTTCarroceriaService;
    }

    @PostMapping
    public ResponseEntity<DetalleOTTCarroceria> create(@Valid @RequestBody CreateDetalleOTTCarroceriaDto dto) {
        DetalleOTTCarroceria detalle = detalleOTTCarroceriaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalle);
    }

    @GetMapping
    public ResponseEntity<List<DetalleOTTCarroceria>> findAll() {
        List<DetalleOTTCarroceria> detalles = detalleOTTCarroceriaService.findAll();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleOTTCarroceria> findById(@PathVariable Integer id) {
        DetalleOTTCarroceria detalle = detalleOTTCarroceriaService.findById(id);
        return ResponseEntity.ok(detalle);
    }

    @GetMapping("/ot-carroceria/{idOtCarroceria}")
    public ResponseEntity<List<DetalleOTTCarroceria>> findByOtCarroceria(@PathVariable Integer idOtCarroceria) {
        List<DetalleOTTCarroceria> detalles = detalleOTTCarroceriaService.findByOtCarroceria(idOtCarroceria);
        return ResponseEntity.ok(detalles);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DetalleOTTCarroceria> update(@PathVariable Integer id,
                                                        @Valid @RequestBody UpdateDetalleOTTCarroceriaDto dto) {
        DetalleOTTCarroceria detalle = detalleOTTCarroceriaService.update(id, dto);
        return ResponseEntity.ok(detalle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteDetalleOTTCarroceriaResponseDto> delete(@PathVariable Integer id) {
        DeleteDetalleOTTCarroceriaResponseDto response = detalleOTTCarroceriaService.delete(id);
        return ResponseEntity.ok(response);
    }
}
