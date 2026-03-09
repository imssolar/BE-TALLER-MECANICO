package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateDetalleOTTEXTDto;
import com.tallermecanico.dto.request.UpdateDetalleOTTEXTDto;
import com.tallermecanico.dto.response.DeleteDetalleOTTEXTResponseDto;
import com.tallermecanico.entity.DetalleOTTEXT;
import com.tallermecanico.service.DetalleOTTEXTService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-ott-ext")
public class DetalleOTTEXTController {

    private final DetalleOTTEXTService detalleOTTEXTService;

    public DetalleOTTEXTController(DetalleOTTEXTService detalleOTTEXTService) {
        this.detalleOTTEXTService = detalleOTTEXTService;
    }

    @PostMapping
    public ResponseEntity<DetalleOTTEXT> create(@Valid @RequestBody CreateDetalleOTTEXTDto dto) {
        DetalleOTTEXT detalle = detalleOTTEXTService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalle);
    }

    @GetMapping
    public ResponseEntity<List<DetalleOTTEXT>> findAll() {
        List<DetalleOTTEXT> detalles = detalleOTTEXTService.findAll();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleOTTEXT> findById(@PathVariable Integer id) {
        DetalleOTTEXT detalle = detalleOTTEXTService.findById(id);
        return ResponseEntity.ok(detalle);
    }

    @GetMapping("/ot-taller-ext/{idOtTallerExt}")
    public ResponseEntity<List<DetalleOTTEXT>> findByOtTallerExt(@PathVariable Integer idOtTallerExt) {
        List<DetalleOTTEXT> detalles = detalleOTTEXTService.findByOtTallerExt(idOtTallerExt);
        return ResponseEntity.ok(detalles);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DetalleOTTEXT> update(@PathVariable Integer id,
                                                 @Valid @RequestBody UpdateDetalleOTTEXTDto dto) {
        DetalleOTTEXT detalle = detalleOTTEXTService.update(id, dto);
        return ResponseEntity.ok(detalle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteDetalleOTTEXTResponseDto> delete(@PathVariable Integer id) {
        DeleteDetalleOTTEXTResponseDto response = detalleOTTEXTService.delete(id);
        return ResponseEntity.ok(response);
    }
}
