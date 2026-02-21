package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateFacturaDetalleTCDto;
import com.tallermecanico.dto.request.UpdateFacturaDetalleTCDto;
import com.tallermecanico.dto.response.DeleteFacturaDetalleTCResponseDto;
import com.tallermecanico.entity.FacturaDetalleTC;
import com.tallermecanico.service.FacturaDetalleTCService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factura-detalle-tc")
public class FacturaDetalleTCController {

    private final FacturaDetalleTCService facturaDetalleTCService;

    public FacturaDetalleTCController(FacturaDetalleTCService facturaDetalleTCService) {
        this.facturaDetalleTCService = facturaDetalleTCService;
    }

    @PostMapping
    public ResponseEntity<FacturaDetalleTC> create(@Valid @RequestBody CreateFacturaDetalleTCDto dto) {
        FacturaDetalleTC facturaDetalleTC = facturaDetalleTCService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(facturaDetalleTC);
    }

    @GetMapping
    public ResponseEntity<List<FacturaDetalleTC>> findAll() {
        List<FacturaDetalleTC> detalles = facturaDetalleTCService.findAll();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/factura/{idFactura}")
    public ResponseEntity<List<FacturaDetalleTC>> findByFactura(@PathVariable Integer idFactura) {
        List<FacturaDetalleTC> detalles = facturaDetalleTCService.findByFactura(idFactura);
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDetalleTC> findById(@PathVariable Integer id) {
        FacturaDetalleTC facturaDetalleTC = facturaDetalleTCService.findById(id);
        return ResponseEntity.ok(facturaDetalleTC);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FacturaDetalleTC> update(@PathVariable Integer id,
                                                    @Valid @RequestBody UpdateFacturaDetalleTCDto dto) {
        FacturaDetalleTC facturaDetalleTC = facturaDetalleTCService.update(id, dto);
        return ResponseEntity.ok(facturaDetalleTC);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteFacturaDetalleTCResponseDto> delete(@PathVariable Integer id) {
        DeleteFacturaDetalleTCResponseDto response = facturaDetalleTCService.delete(id);
        return ResponseEntity.ok(response);
    }
}
