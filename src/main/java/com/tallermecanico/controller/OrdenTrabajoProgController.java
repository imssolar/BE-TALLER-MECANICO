package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateOrdenTrabajoProgDto;
import com.tallermecanico.dto.request.UpdateOrdenTrabajoProgDto;
import com.tallermecanico.dto.response.DeleteOrdenTrabajoProgResponseDto;
import com.tallermecanico.entity.OrdenTrabajoProg;
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
    public ResponseEntity<OrdenTrabajoProg> create(@Valid @RequestBody CreateOrdenTrabajoProgDto dto) {
        OrdenTrabajoProg otp = ordenTrabajoProgService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(otp);
    }

    @GetMapping
    public ResponseEntity<List<OrdenTrabajoProg>> findAll() {
        List<OrdenTrabajoProg> ordenes = ordenTrabajoProgService.findAll();
        return ResponseEntity.ok(ordenes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenTrabajoProg> findById(@PathVariable Integer id) {
        OrdenTrabajoProg otp = ordenTrabajoProgService.findById(id);
        return ResponseEntity.ok(otp);
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<OrdenTrabajoProg>> findByBus(@PathVariable Integer idBus) {
        List<OrdenTrabajoProg> ordenes = ordenTrabajoProgService.findByBus(idBus);
        return ResponseEntity.ok(ordenes);
    }

    @GetMapping("/terminal/{idTerminal}")
    public ResponseEntity<List<OrdenTrabajoProg>> findByTerminal(@PathVariable Integer idTerminal) {
        List<OrdenTrabajoProg> ordenes = ordenTrabajoProgService.findByTerminal(idTerminal);
        return ResponseEntity.ok(ordenes);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrdenTrabajoProg> update(@PathVariable Integer id,
                                                    @Valid @RequestBody UpdateOrdenTrabajoProgDto dto) {
        OrdenTrabajoProg otp = ordenTrabajoProgService.update(id, dto);
        return ResponseEntity.ok(otp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOrdenTrabajoProgResponseDto> delete(@PathVariable Integer id) {
        DeleteOrdenTrabajoProgResponseDto response = ordenTrabajoProgService.delete(id);
        return ResponseEntity.ok(response);
    }
}
