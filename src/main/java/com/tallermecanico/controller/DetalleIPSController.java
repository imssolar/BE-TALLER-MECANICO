package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateDetalleIPSDto;
import com.tallermecanico.dto.request.UpdateDetalleIPSDto;
import com.tallermecanico.dto.response.DeleteDetalleIPSResponseDto;
import com.tallermecanico.entity.DetalleIPS;
import com.tallermecanico.service.DetalleIPSService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-ips")
public class DetalleIPSController {

    private final DetalleIPSService detalleIPSService;

    public DetalleIPSController(DetalleIPSService detalleIPSService) {
        this.detalleIPSService = detalleIPSService;
    }

    @PostMapping
    public ResponseEntity<DetalleIPS> create(@Valid @RequestBody CreateDetalleIPSDto dto) {
        DetalleIPS detalleIPS = detalleIPSService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleIPS);
    }

    @GetMapping
    public ResponseEntity<List<DetalleIPS>> findAll() {
        List<DetalleIPS> detalles = detalleIPSService.findAll();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleIPS> findById(@PathVariable Integer id) {
        DetalleIPS detalleIPS = detalleIPSService.findById(id);
        return ResponseEntity.ok(detalleIPS);
    }

    @GetMapping("/orden-trabajo-prog/{idOrdenTrabajoProg}")
    public ResponseEntity<List<DetalleIPS>> findByOrdenTrabajoProg(@PathVariable Integer idOrdenTrabajoProg) {
        List<DetalleIPS> detalles = detalleIPSService.findByOrdenTrabajoProg(idOrdenTrabajoProg);
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/orden-trabajo-movil/{idOrdenTrabajoMovil}")
    public ResponseEntity<List<DetalleIPS>> findByOrdenTrabajoMovil(@PathVariable Integer idOrdenTrabajoMovil) {
        List<DetalleIPS> detalles = detalleIPSService.findByOrdenTrabajoMovil(idOrdenTrabajoMovil);
        return ResponseEntity.ok(detalles);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DetalleIPS> update(@PathVariable Integer id,
                                              @Valid @RequestBody UpdateDetalleIPSDto dto) {
        DetalleIPS detalleIPS = detalleIPSService.update(id, dto);
        return ResponseEntity.ok(detalleIPS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteDetalleIPSResponseDto> delete(@PathVariable Integer id) {
        DeleteDetalleIPSResponseDto response = detalleIPSService.delete(id);
        return ResponseEntity.ok(response);
    }
}
