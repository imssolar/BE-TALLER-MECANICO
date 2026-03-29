package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateOrdenTrabajoMovilDto;
import com.tallermecanico.dto.request.UpdateOrdenTrabajoMovilDto;
import com.tallermecanico.dto.response.DeleteOrdenTrabajoMovilResponseDto;
import com.tallermecanico.dto.response.OrdenTrabajoMovilResponseDto;
import com.tallermecanico.service.OrdenTrabajoMovilService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes-trabajo-movil")
public class OrdenTrabajoMovilController {

    private final OrdenTrabajoMovilService ordenTrabajoMovilService;

    public OrdenTrabajoMovilController(OrdenTrabajoMovilService ordenTrabajoMovilService) {
        this.ordenTrabajoMovilService = ordenTrabajoMovilService;
    }

    @PostMapping
    public ResponseEntity<OrdenTrabajoMovilResponseDto> create(@Valid @RequestBody CreateOrdenTrabajoMovilDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenTrabajoMovilService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<OrdenTrabajoMovilResponseDto>> findAll() {
        return ResponseEntity.ok(ordenTrabajoMovilService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenTrabajoMovilResponseDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(ordenTrabajoMovilService.findById(id));
    }

    @GetMapping("/terminal/{idTerminal}")
    public ResponseEntity<List<OrdenTrabajoMovilResponseDto>> findByTerminal(@PathVariable Integer idTerminal) {
        return ResponseEntity.ok(ordenTrabajoMovilService.findByTerminal(idTerminal));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrdenTrabajoMovilResponseDto> update(@PathVariable Integer id,
                                                               @Valid @RequestBody UpdateOrdenTrabajoMovilDto dto) {
        return ResponseEntity.ok(ordenTrabajoMovilService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOrdenTrabajoMovilResponseDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(ordenTrabajoMovilService.delete(id));
    }
}
