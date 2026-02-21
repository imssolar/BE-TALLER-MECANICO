package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateOrdenTrabajoDto;
import com.tallermecanico.dto.request.UpdateOrdenTrabajoDto;
import com.tallermecanico.dto.response.DeleteOrdenTrabajoResponseDto;
import com.tallermecanico.entity.OrdenTrabajo;
import com.tallermecanico.service.OrdenTrabajoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes-trabajo")
public class OrdenTrabajoController {

    private final OrdenTrabajoService ordenTrabajoService;

    public OrdenTrabajoController(OrdenTrabajoService ordenTrabajoService) {
        this.ordenTrabajoService = ordenTrabajoService;
    }

    @PostMapping
    public ResponseEntity<OrdenTrabajo> create(@Valid @RequestBody CreateOrdenTrabajoDto dto) {
        OrdenTrabajo ordenTrabajo = ordenTrabajoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenTrabajo);
    }

    @GetMapping
    public ResponseEntity<List<OrdenTrabajo>> findAll() {
        List<OrdenTrabajo> ordenes = ordenTrabajoService.findAll();
        return ResponseEntity.ok(ordenes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenTrabajo> findById(@PathVariable Integer id) {
        OrdenTrabajo ordenTrabajo = ordenTrabajoService.findById(id);
        return ResponseEntity.ok(ordenTrabajo);
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<OrdenTrabajo>> findByBus(@PathVariable Integer idBus) {
        List<OrdenTrabajo> ordenes = ordenTrabajoService.findByBus(idBus);
        return ResponseEntity.ok(ordenes);
    }

    @GetMapping("/terminal/{idTerminal}")
    public ResponseEntity<List<OrdenTrabajo>> findByTerminal(@PathVariable Integer idTerminal) {
        List<OrdenTrabajo> ordenes = ordenTrabajoService.findByTerminal(idTerminal);
        return ResponseEntity.ok(ordenes);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrdenTrabajo> update(@PathVariable Integer id,
                                               @Valid @RequestBody UpdateOrdenTrabajoDto dto) {
        OrdenTrabajo ordenTrabajo = ordenTrabajoService.update(id, dto);
        return ResponseEntity.ok(ordenTrabajo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOrdenTrabajoResponseDto> delete(@PathVariable Integer id) {
        DeleteOrdenTrabajoResponseDto response = ordenTrabajoService.delete(id);
        return ResponseEntity.ok(response);
    }
}
