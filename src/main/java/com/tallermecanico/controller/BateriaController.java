package com.tallermecanico.controller;

import com.tallermecanico.dto.request.CreateBateriaDto;
import com.tallermecanico.dto.request.UpdateBateriaDto;
import com.tallermecanico.dto.response.DeleteBateriaResponseDto;
import com.tallermecanico.entity.Bateria;
import com.tallermecanico.service.BateriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baterias")
public class BateriaController {

    private final BateriaService bateriaService;

    public BateriaController(BateriaService bateriaService) {
        this.bateriaService = bateriaService;
    }

    @PostMapping
    public ResponseEntity<Bateria> create(@Valid @RequestBody CreateBateriaDto dto) {
        Bateria bateria = bateriaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bateria);
    }

    @GetMapping
    public ResponseEntity<List<Bateria>> findAll() {
        List<Bateria> baterias = bateriaService.findAll();
        return ResponseEntity.ok(baterias);
    }

    @GetMapping("/activos")
    public ResponseEntity<List<Bateria>> findActivos() {
        List<Bateria> baterias = bateriaService.findActivos();
        return ResponseEntity.ok(baterias);
    }

    @GetMapping("/inactivos")
    public ResponseEntity<List<Bateria>> findInactivos() {
        List<Bateria> baterias = bateriaService.findInactivos();
        return ResponseEntity.ok(baterias);
    }

    @GetMapping("/bus/{idBus}")
    public ResponseEntity<List<Bateria>> findByBus(@PathVariable Integer idBus) {
        List<Bateria> baterias = bateriaService.findByBus(idBus);
        return ResponseEntity.ok(baterias);
    }

    @GetMapping("/estado/{idEstado}")
    public ResponseEntity<List<Bateria>> findByEstado(@PathVariable Integer idEstado) {
        List<Bateria> baterias = bateriaService.findByEstado(idEstado);
        return ResponseEntity.ok(baterias);
    }

    @GetMapping("/marca/{idMarca}")
    public ResponseEntity<List<Bateria>> findByMarca(@PathVariable Integer idMarca) {
        List<Bateria> baterias = bateriaService.findByMarca(idMarca);
        return ResponseEntity.ok(baterias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bateria> findById(@PathVariable Integer id) {
        Bateria bateria = bateriaService.findById(id);
        return ResponseEntity.ok(bateria);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Bateria> update(@PathVariable Integer id,
                                          @Valid @RequestBody UpdateBateriaDto dto) {
        Bateria bateria = bateriaService.update(id, dto);
        return ResponseEntity.ok(bateria);
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Bateria> desactivar(@PathVariable Integer id) {
        Bateria bateria = bateriaService.desactivar(id);
        return ResponseEntity.ok(bateria);
    }

    @PatchMapping("/{id}/activar")
    public ResponseEntity<Bateria> activar(@PathVariable Integer id) {
        Bateria bateria = bateriaService.activar(id);
        return ResponseEntity.ok(bateria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteBateriaResponseDto> delete(@PathVariable Integer id) {
        DeleteBateriaResponseDto response = bateriaService.delete(id);
        return ResponseEntity.ok(response);
    }
}
