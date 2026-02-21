package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateFacturaMantDto;
import com.tallermecanico.dto.request.UpdateFacturaMantDto;
import com.tallermecanico.dto.response.DeleteFacturaMantResponseDto;
import com.tallermecanico.entity.FacturaMant;
import com.tallermecanico.service.FacturaMantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas-mant")
public class FacturaMantController {

    private final FacturaMantService facturaMantService;

    public FacturaMantController(FacturaMantService facturaMantService) {
        this.facturaMantService = facturaMantService;
    }

    @PostMapping
    public ResponseEntity<FacturaMant> create(@Valid @RequestBody CreateFacturaMantDto dto) {
        FacturaMant facturaMant = facturaMantService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(facturaMant);
    }

    @GetMapping
    public ResponseEntity<List<FacturaMant>> findAll() {
        List<FacturaMant> facturasMant = facturaMantService.findAll();
        return ResponseEntity.ok(facturasMant);
    }

    @GetMapping("/proveedor/{idProveedor}")
    public ResponseEntity<List<FacturaMant>> findByProveedor(@PathVariable Integer idProveedor) {
        List<FacturaMant> facturasMant = facturaMantService.findByProveedor(idProveedor);
        return ResponseEntity.ok(facturasMant);
    }

    @GetMapping("/taller-externo/{idTallerExterno}")
    public ResponseEntity<List<FacturaMant>> findByTallerExterno(@PathVariable Integer idTallerExterno) {
        List<FacturaMant> facturasMant = facturaMantService.findByTallerExterno(idTallerExterno);
        return ResponseEntity.ok(facturasMant);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaMant> findById(@PathVariable Integer id) {
        FacturaMant facturaMant = facturaMantService.findById(id);
        return ResponseEntity.ok(facturaMant);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FacturaMant> update(@PathVariable Integer id,
                                               @Valid @RequestBody UpdateFacturaMantDto dto) {
        FacturaMant facturaMant = facturaMantService.update(id, dto);
        return ResponseEntity.ok(facturaMant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteFacturaMantResponseDto> delete(@PathVariable Integer id) {
        DeleteFacturaMantResponseDto response = facturaMantService.delete(id);
        return ResponseEntity.ok(response);
    }
}
