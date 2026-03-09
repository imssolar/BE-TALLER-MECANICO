package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateFacturaDetalleMantDto;
import com.tallermecanico.dto.request.UpdateFacturaDetalleMantDto;
import com.tallermecanico.dto.response.DeleteFacturaDetalleMantResponseDto;
import com.tallermecanico.entity.FacturaDetalleMant;
import com.tallermecanico.service.FacturaDetalleMantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factura-detalle-mant")
public class FacturaDetalleMantController {

    private final FacturaDetalleMantService facturaDetalleMantService;

    public FacturaDetalleMantController(FacturaDetalleMantService facturaDetalleMantService) {
        this.facturaDetalleMantService = facturaDetalleMantService;
    }

    @PostMapping
    public ResponseEntity<FacturaDetalleMant> create(@Valid @RequestBody CreateFacturaDetalleMantDto dto) {
        FacturaDetalleMant detalle = facturaDetalleMantService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalle);
    }

    @GetMapping
    public ResponseEntity<List<FacturaDetalleMant>> findAll() {
        List<FacturaDetalleMant> detalles = facturaDetalleMantService.findAll();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/factura/{idFactura}")
    public ResponseEntity<List<FacturaDetalleMant>> findByFactura(@PathVariable Integer idFactura) {
        List<FacturaDetalleMant> detalles = facturaDetalleMantService.findByFactura(idFactura);
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDetalleMant> findById(@PathVariable Integer id) {
        FacturaDetalleMant detalle = facturaDetalleMantService.findById(id);
        return ResponseEntity.ok(detalle);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FacturaDetalleMant> update(@PathVariable Integer id,
                                                      @Valid @RequestBody UpdateFacturaDetalleMantDto dto) {
        FacturaDetalleMant detalle = facturaDetalleMantService.update(id, dto);
        return ResponseEntity.ok(detalle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteFacturaDetalleMantResponseDto> delete(@PathVariable Integer id) {
        DeleteFacturaDetalleMantResponseDto response = facturaDetalleMantService.delete(id);
        return ResponseEntity.ok(response);
    }
}
