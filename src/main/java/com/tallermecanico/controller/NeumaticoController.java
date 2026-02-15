package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateNeumaticoDto;
import com.tallermecanico.dto.request.UpdateNeumaticoDto;
import com.tallermecanico.dto.response.DeleteNeumaticoResponseDto;
import com.tallermecanico.entity.Neumatico;
import com.tallermecanico.service.NeumaticoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/neumaticos")
public class NeumaticoController {

    private final NeumaticoService neumaticoService;

    public NeumaticoController(NeumaticoService neumaticoService) {
        this.neumaticoService = neumaticoService;
    }

    @PostMapping
    public ResponseEntity<Neumatico> create(@Valid @RequestBody CreateNeumaticoDto dto) {
        Neumatico neumatico = neumaticoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(neumatico);
    }

    @GetMapping
    public ResponseEntity<List<Neumatico>> findAll() {
        List<Neumatico> neumaticos = neumaticoService.findAll();
        return ResponseEntity.ok(neumaticos);
    }

    @GetMapping("/activos")
    public ResponseEntity<List<Neumatico>> findActivos() {
        List<Neumatico> neumaticos = neumaticoService.findActivos();
        return ResponseEntity.ok(neumaticos);
    }

    @GetMapping("/inactivos")
    public ResponseEntity<List<Neumatico>> findInactivos() {
        List<Neumatico> neumaticos = neumaticoService.findInactivos();
        return ResponseEntity.ok(neumaticos);
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<Neumatico>> findByBus(@PathVariable Integer idBus) {
        List<Neumatico> neumaticos = neumaticoService.findByBus(idBus);
        return ResponseEntity.ok(neumaticos);
    }

    @GetMapping("/estado/{idEstado}")
    public ResponseEntity<List<Neumatico>> findByEstado(@PathVariable Integer idEstado) {
        List<Neumatico> neumaticos = neumaticoService.findByEstado(idEstado);
        return ResponseEntity.ok(neumaticos);
    }

    @GetMapping("/marca/{idMarca}")
    public ResponseEntity<List<Neumatico>> findByMarca(@PathVariable Integer idMarca) {
        List<Neumatico> neumaticos = neumaticoService.findByMarca(idMarca);
        return ResponseEntity.ok(neumaticos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Neumatico> findById(@PathVariable Integer id) {
        Neumatico neumatico = neumaticoService.findById(id);
        return ResponseEntity.ok(neumatico);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Neumatico> update(@PathVariable Integer id,
                                           @Valid @RequestBody UpdateNeumaticoDto dto) {
        Neumatico neumatico = neumaticoService.update(id, dto);
        return ResponseEntity.ok(neumatico);
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Neumatico> desactivar(@PathVariable Integer id) {
        Neumatico neumatico = neumaticoService.desactivar(id);
        return ResponseEntity.ok(neumatico);
    }

    @PatchMapping("/{id}/activar")
    public ResponseEntity<Neumatico> activar(@PathVariable Integer id) {
        Neumatico neumatico = neumaticoService.activar(id);
        return ResponseEntity.ok(neumatico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteNeumaticoResponseDto> delete(@PathVariable Integer id) {
        DeleteNeumaticoResponseDto response = neumaticoService.delete(id);
        return ResponseEntity.ok(response);
    }
}
