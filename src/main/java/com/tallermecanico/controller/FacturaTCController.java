package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateFacturaTCDto;
import com.tallermecanico.dto.request.UpdateFacturaTCDto;
import com.tallermecanico.dto.response.DeleteFacturaTCResponseDto;
import com.tallermecanico.entity.FacturaTC;
import com.tallermecanico.service.FacturaTCService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas-tc")
public class FacturaTCController {

    private final FacturaTCService facturaTCService;

    public FacturaTCController(FacturaTCService facturaTCService) {
        this.facturaTCService = facturaTCService;
    }

    @PostMapping
    public ResponseEntity<FacturaTC> create(@Valid @RequestBody CreateFacturaTCDto dto) {
        FacturaTC facturaTC = facturaTCService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(facturaTC);
    }

    @GetMapping
    public ResponseEntity<List<FacturaTC>> findAll() {
        List<FacturaTC> facturas = facturaTCService.findAll();
        return ResponseEntity.ok(facturas);
    }

    @GetMapping("/proveedor/{idProveedor}")
    public ResponseEntity<List<FacturaTC>> findByProveedor(@PathVariable Integer idProveedor) {
        List<FacturaTC> facturas = facturaTCService.findByProveedor(idProveedor);
        return ResponseEntity.ok(facturas);
    }

    @GetMapping("/terminal/{idTerminal}")
    public ResponseEntity<List<FacturaTC>> findByTerminal(@PathVariable Integer idTerminal) {
        List<FacturaTC> facturas = facturaTCService.findByTerminal(idTerminal);
        return ResponseEntity.ok(facturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaTC> findById(@PathVariable Integer id) {
        FacturaTC facturaTC = facturaTCService.findById(id);
        return ResponseEntity.ok(facturaTC);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FacturaTC> update(@PathVariable Integer id,
                                             @Valid @RequestBody UpdateFacturaTCDto dto) {
        FacturaTC facturaTC = facturaTCService.update(id, dto);
        return ResponseEntity.ok(facturaTC);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteFacturaTCResponseDto> delete(@PathVariable Integer id) {
        DeleteFacturaTCResponseDto response = facturaTCService.delete(id);
        return ResponseEntity.ok(response);
    }
}
