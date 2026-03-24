package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateOrdenTrabajoDto;
import com.tallermecanico.dto.request.UpdateOrdenTrabajoDto;
import com.tallermecanico.dto.response.DeleteOrdenTrabajoResponseDto;
import com.tallermecanico.dto.response.OrdenTrabajoResponseDto;
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
    public ResponseEntity<OrdenTrabajoResponseDto> create(@Valid @RequestBody CreateOrdenTrabajoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenTrabajoService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<OrdenTrabajoResponseDto>> findAll() {
        return ResponseEntity.ok(ordenTrabajoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenTrabajoResponseDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(ordenTrabajoService.findById(id));
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<OrdenTrabajoResponseDto>> findByBus(@PathVariable Integer idBus) {
        return ResponseEntity.ok(ordenTrabajoService.findByBus(idBus));
    }

    @GetMapping("/terminal/{idTerminal}")
    public ResponseEntity<List<OrdenTrabajoResponseDto>> findByTerminal(@PathVariable Integer idTerminal) {
        return ResponseEntity.ok(ordenTrabajoService.findByTerminal(idTerminal));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrdenTrabajoResponseDto> update(@PathVariable Integer id,
                                                          @Valid @RequestBody UpdateOrdenTrabajoDto dto) {
        return ResponseEntity.ok(ordenTrabajoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOrdenTrabajoResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(ordenTrabajoService.delete(id));
    }
}
