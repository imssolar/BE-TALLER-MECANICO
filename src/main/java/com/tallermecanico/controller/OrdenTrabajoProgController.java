package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateOrdenTrabajoProgDto;
import com.tallermecanico.dto.request.UpdateOrdenTrabajoProgDto;
import com.tallermecanico.dto.response.DeleteOrdenTrabajoProgResponseDto;
import com.tallermecanico.dto.response.OrdenTrabajoProgResponseDto;
import com.tallermecanico.service.OrdenTrabajoProgService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes-trabajo-prog")
public class OrdenTrabajoProgController {

    private final OrdenTrabajoProgService ordenTrabajoProgService;

    public OrdenTrabajoProgController(OrdenTrabajoProgService ordenTrabajoProgService) {
        this.ordenTrabajoProgService = ordenTrabajoProgService;
    }

    @PostMapping
    public ResponseEntity<OrdenTrabajoProgResponseDto> create(@Valid @RequestBody CreateOrdenTrabajoProgDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenTrabajoProgService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<OrdenTrabajoProgResponseDto>> findAll() {
        return ResponseEntity.ok(ordenTrabajoProgService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenTrabajoProgResponseDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(ordenTrabajoProgService.findById(id));
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<OrdenTrabajoProgResponseDto>> findByBus(@PathVariable Integer idBus) {
        return ResponseEntity.ok(ordenTrabajoProgService.findByBus(idBus));
    }

    @GetMapping("/terminal/{idTerminal}")
    public ResponseEntity<List<OrdenTrabajoProgResponseDto>> findByTerminal(@PathVariable Integer idTerminal) {
        return ResponseEntity.ok(ordenTrabajoProgService.findByTerminal(idTerminal));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrdenTrabajoProgResponseDto> update(@PathVariable Integer id,
                                                              @Valid @RequestBody UpdateOrdenTrabajoProgDto dto) {
        return ResponseEntity.ok(ordenTrabajoProgService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOrdenTrabajoProgResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(ordenTrabajoProgService.delete(id));
    }
}
